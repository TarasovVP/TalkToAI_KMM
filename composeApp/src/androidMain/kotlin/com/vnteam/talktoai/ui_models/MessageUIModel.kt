package com.vnteam.talktoai.ui_models

import androidx.compose.runtime.mutableStateOf
import domain.CommonExtensions.EMPTY
import domain.Constants.DEFAULT_CHAT_ID
import domain.enums.MessageStatus
import kotlinx.serialization.Serializable

@Serializable
data class MessageUIModel(
    var id: Long = 0,
    var chatId: Long = DEFAULT_CHAT_ID,
    var author: String = String.EMPTY,
    var message: String = String.EMPTY,
    var updatedAt: Long = 0,
    var status: MessageStatus = MessageStatus.REQUESTING,
    var errorMessage: String = String.EMPTY,
    var isTruncated: Boolean = false
) {
    var isCheckedToDelete = mutableStateOf(false)
}