package com.vnteam.talktoai.chat

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vnteam.talktoai.base.BaseViewModel
import data.database.db_entities.Chat
import domain.ApiRequest
import domain.CommonExtensions.isNull
import domain.enums.MessageStatus
import domain.sealed_classes.Result
import domain.usecases.ChatUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import mapperimpls.MessageUIMapper
import ui_models.MessageUIModel

class ChatViewModel(
    application: Application,
    private val chatUseCase: ChatUseCase,
    private val messageUIMapper: MessageUIMapper,
) : BaseViewModel(application) {

    val currentChatLiveData = MutableLiveData<Chat?>()
    val messagesLiveData = MutableLiveData<List<MessageUIModel>>()

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
                    currentChatLiveData.postValue(Chat())
                } else {
                    currentChatLiveData.postValue(chat)
                }
                hideProgress()
            }
        }
    }

    fun getMessagesFromChat(chatId: Long) {
        showProgress()
        messagesFlowSubscription?.cancel()
        Log.e(
            "messagesTAG",
            "ChatViewModel getMessagesFromChat before messagesLiveData ${messagesLiveData.value?.map { it.message }}"
        )
        messagesFlowSubscription = launch {
            chatUseCase.getMessagesFromChat(chatId).catch {
                hideProgress()
                Log.e(
                    "apiTAG",
                    "ChatViewModel getMessagesFromChat catch localizedMessage ${it.localizedMessage} isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                )
            }.collect { result ->
                Log.e(
                    "apiTAG",
                    "ChatViewModel getMessagesFromChat collect result.size ${result.size} chatId $chatId isProgressProcessLiveData ${progressVisibilityLiveData.value}"
                )
                Log.e(
                    "messagesTAG",
                    "ChatViewModel getMessagesFromChat after messagesLiveData ${messagesLiveData.value?.map { it.message }}"
                )
                messagesLiveData.postValue(messageUIMapper.mapToUIModelList(result))
                hideProgress()
            }
        }
    }

    fun sendRequest(temporaryMessage: MessageUIModel, apiRequest: ApiRequest) {
        Log.e(
            "messagesTAG",
            "ChatViewModel sendRequest messagesLiveData ${messagesLiveData.value?.map { it.message }}"
        )
        showProgress()
        launch {
            chatUseCase.sendRequest(apiRequest).catch {
                hideProgress()
                Log.e(
                    "apiTAG",
                    "ChatViewModel sendRequest catch localizedMessage ${it.localizedMessage} isProgressProcessLiveData ${progressVisibilityLiveData.value}"
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
                        Log.e(
                            "apiTAG",
                            "ChatViewModel sendRequest Result.Failure localizedMessage ${result.errorMessage}  isProgressProcessLiveData ${progressVisibilityLiveData.value}"
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
        Log.e("truncateTAG", "ChatViewModel updateMessage message $message")
        launch {
            chatUseCase.insertMessage(messageUIMapper.mapFromUIModel(message))
        }
    }

    fun deleteMessages(messageIds: List<Long>) {
        Log.e("truncateTAG", "ChatViewModel deleteMessages messageIds $messageIds")
        launch {
            chatUseCase.deleteMessages(messageIds)
        }
    }

    override fun onCleared() {
        super.onCleared()
        messagesFlowSubscription?.cancel()
    }
}