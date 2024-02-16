package data.database.dao

import data.database.db_entities.Message
import kotlinx.coroutines.flow.Flow

interface MessageDao {

    fun insertMessages(messages: List<Message>)

    fun insertMessage(message: Message)

    fun getMessages(): Flow<List<Message>>

    fun getMessagesFromChat(chatId: Long): Flow<List<Message>>

    fun deleteMessagesFromChat(chatId: Long)

    fun deleteMessage(id: Long)

    fun deleteMessages(messageIds: List<Long>)
}