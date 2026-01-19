package chat

import data.database.db_entities.Chat
import domain.ApiRequest
import domain.CommonExtensions.isNull
import domain.enums.MessageStatus
import domain.sealed_classes.Result
import domain.usecases.ChatUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import mapperimpls.MessageUIMapper
import ui_models.MessageUIModel

class ChatViewModel(
    private val chatUseCase: ChatUseCase,
    private val messageUIMapper: MessageUIMapper,
) {

    val currentChatStateFlow = MutableStateFlow<Chat?>(null)
    val messagesStateFlow = MutableStateFlow<List<MessageUIModel>>(emptyList())

    private var messagesFlowSubscription: Job? = null
    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    fun insertChat(chat: Chat) {
        viewModelScope.launch {
            chatUseCase.insertChat(chat)
        }
    }

    fun getCurrentChat(chatId: Long) {
        viewModelScope.launch {
            chatUseCase.getCurrentChat(chatId).catch {
                it.printStackTrace()
            }.collect { chat ->
                if (chat.isNull()) {
                    //TODO remove .apply { id = 1 }
                    currentChatStateFlow.value = Chat().apply { id = 1 }
                } else {
                    currentChatStateFlow.value = chat
                }
            }
        }
    }

    fun getMessagesFromChat(chatId: Long) {
        messagesFlowSubscription = viewModelScope.launch {
            chatUseCase.getMessagesFromChat(chatId).catch {
                it.printStackTrace()
            }.collect { result ->
                messagesStateFlow.value = messageUIMapper.mapToUIModelList(result)
            }
        }
    }

    fun sendRequest(
        temporaryMessage: MessageUIModel,
        apiRequest: ApiRequest,
    ) {
        viewModelScope.launch {
            chatUseCase.sendRequest(apiRequest).catch {
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
                    }
                }
            }
        }
    }

    fun insertMessage(message: MessageUIModel) {
        viewModelScope.launch {
            chatUseCase.insertMessage(messageUIMapper.mapFromUIModel(message))
        }
    }

    fun updateMessage(message: MessageUIModel) {
        viewModelScope.launch {
            chatUseCase.insertMessage(messageUIMapper.mapFromUIModel(message))
        }
    }

    fun deleteMessages(messageIds: List<Long>) {
        viewModelScope.launch {
            chatUseCase.deleteMessages(messageIds)
        }
    }

    fun onCleared() {
        messagesFlowSubscription?.cancel()
        viewModelScope.cancel()
    }
}