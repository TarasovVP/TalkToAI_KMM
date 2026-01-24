package presentation.chat

import presentation.base.BaseViewModel
import data.database.db_entities.Chat
import domain.ApiRequest
import domain.CommonExtensions.isNull
import domain.enums.MessageStatus
import domain.sealed_classes.Result
import domain.usecases.ChatUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import mapperimpls.MessageUIMapper
import ui_models.MessageUIModel

class ChatViewModel(
    private val chatUseCase: ChatUseCase,
    private val messageUIMapper: MessageUIMapper,
) : BaseViewModel() {

    val currentChatLiveData = MutableStateFlow<Chat?>(Chat())
    val messagesLiveData = MutableStateFlow<List<MessageUIModel>>(emptyList())

    private var messagesFlowSubscription: Job? = null

    fun insertChat(chat: Chat) {
        launch {
            chatUseCase.insertChat(chat)
        }
    }

    fun getCurrentChat(chatId: Long) {
        showProgress()
        launch {
            chatUseCase.getCurrentChat(chatId).catch {
                hideProgress()
            }.collect { chat ->
                if (chat.isNull()) {
                    currentChatLiveData.value = Chat()
                } else {
                    currentChatLiveData.value = chat
                }
                hideProgress()
            }
        }
    }

    fun getMessagesFromChat(chatId: Long) {
        showProgress()
        messagesFlowSubscription?.cancel()
        println(
            "messagesTAG ChatViewModel getMessagesFromChat before messagesLiveData ${messagesLiveData.value.map { it.message }}"
        )
        messagesFlowSubscription = launch {
            chatUseCase.getMessagesFromChat(chatId).catch {
                hideProgress()
                println(
                    "apiTAG ChatViewModel getMessagesFromChat catch localizedMessage ${it.message} isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                )
            }.collect { result ->
                println(
                    "apiTAG ChatViewModel getMessagesFromChat collect result.size ${result.size} chatId $chatId isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                )
                println(
                    "messagesTAG ChatViewModel getMessagesFromChat after messagesLiveData ${messagesLiveData.value?.map { it.message }}"
                )
                messagesLiveData.value = messageUIMapper.mapToUIModelList(result)
                hideProgress()
            }
        }
    }

    fun sendRequest(temporaryMessage: MessageUIModel, apiRequest: ApiRequest) {
        println(
            "messagesTAG ChatViewModel sendRequest messagesLiveData ${messagesLiveData.value?.map { it.message }}"
        )
        showProgress()
        launch {
            chatUseCase.sendRequest(apiRequest).catch {
                hideProgress()
                println(
                    "apiTAG ChatViewModel sendRequest catch localizedMessage ${it.message} isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                )
            }.collect { result ->
                when (result) {
                    is Result.Success -> result.data?.let { apiResponse ->
                        insertMessage(temporaryMessage.apply {
                            author = apiResponse.model.orEmpty()
                            message = apiResponse.choices?.firstOrNull()?.message?.content.orEmpty()
                            updatedAt = apiResponse.created?.toLongOrNull() ?: 0
                            status = MessageStatus.SUCCESS
                        })
                    }

                    is Result.Failure -> {
                        insertMessage(temporaryMessage.apply {
                            status = MessageStatus.ERROR
                            errorMessage = result.errorMessage.orEmpty()
                        })
                        println(
                            "apiTAG ChatViewModel sendRequest Result.Failure localizedMessage ${result.errorMessage}  isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                        )
                    }
                }
                hideProgress()
            }
        }
    }

    fun insertMessage(message: MessageUIModel) {
        launch {
            chatUseCase.insertMessage(messageUIMapper.mapFromUIModel(message))
        }
    }

    fun updateMessage(message: MessageUIModel) {
        println("truncateTAG ChatViewModel updateMessage message $message")
        launch {
            chatUseCase.insertMessage(messageUIMapper.mapFromUIModel(message))
        }
    }

    fun deleteMessages(messageIds: List<Long>) {
        println("truncateTAG ChatViewModel deleteMessages messageIds $messageIds")
        launch {
            chatUseCase.deleteMessages(messageIds)
        }
    }

    override fun onCleared() {
        super.onCleared()
        messagesFlowSubscription?.cancel()
    }
}