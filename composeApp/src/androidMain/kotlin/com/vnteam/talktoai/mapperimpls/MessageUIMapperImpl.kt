package com.vnteam.talktoai.mapperimpls

import com.vnteam.talktoai.ui_models.MessageUIModel
import data.database.db_entities.Message
import domain.CommonExtensions.orZero
import domain.enums.MessageStatus

class MessageUIMapperImpl : MessageUIMapper {

    override fun mapToUIModel(from: Message): MessageUIModel {
        return MessageUIModel(from.id.orZero(), chatId = from.chatId.orZero(),
        author = from.author.orEmpty(),
        message = from.message.orEmpty(),
        updatedAt = from.updatedAt.orZero(),
        status = from.status ?: MessageStatus.REQUESTING,
        errorMessage = from.errorMessage.orEmpty(),
        isTruncated = from.truncated)
    }

    override fun mapFromUIModel(to: MessageUIModel): Message {
        return Message(to.id, chatId = to.chatId,
            author = to.author,
            message = to.message,
            updatedAt = to.updatedAt,
            status = to.status,
            errorMessage = to.errorMessage,
            truncated = to.isTruncated
        )
    }

    override fun mapToUIModelList(fromList: List<Message>): List<MessageUIModel> {
        return fromList.map { mapToUIModel(it) }
    }

    override fun mapFromUIModelList(toList: List<MessageUIModel>): List<Message> {
        return toList.map { mapFromUIModel(it) }
    }
}