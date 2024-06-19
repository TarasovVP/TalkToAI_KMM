package data.database.dao

import data.database.db_entities.Message
import kotlinx.coroutines.flow.Flow

interface MessageDao {

    suspend fun insertMessages(messages: List<Message>)

    suspend fun insertMessage(message: Message)

    suspend fun getMessages(): Flow<List<Message>>

    suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>>

    suspend fun deleteMessagesFromChat(chatId: Long)

    suspend fun deleteMessage(id: Long)

    suspend fun deleteMessages(messageIds: List<Long>)
}