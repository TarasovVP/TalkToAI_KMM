package domain.repositories

import data.database.db_entities.Message
import domain.ApiRequest
import domain.ApiResponse
import domain.TestClass
import domain.sealed_classes.Result
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    suspend fun insertMessages(messages: List<Message>)

    suspend fun insertMessage(message: Message)

    suspend fun getMessages(): Flow<List<Message>>

    suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>>

    suspend fun deleteMessage(id: Long)

    suspend fun deleteMessages(messageIds: List<Long>)

    suspend fun deleteMessagesFromChat(chatId: Long)

    suspend fun updateMessages(messages: List<Message>)

    suspend fun sendRequest(apiRequest: ApiRequest): Flow<Result<ApiResponse>>

    fun getTest(): TestClass
}