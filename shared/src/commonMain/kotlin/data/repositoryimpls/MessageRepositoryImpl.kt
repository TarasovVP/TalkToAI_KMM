package data.repositoryimpls

import data.database.dao.MessageDao
import data.database.db_entities.Message
import data.network.ApiService
import domain.ApiRequest
import domain.ApiResponse
import domain.repositories.MessageRepository
import domain.CommonExtensions.handleResponse
import domain.CommonExtensions.orZero
import domain.TestClass
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MessageRepositoryImpl(
    private val messageDao: MessageDao,
    private val apiService: ApiService,
) : MessageRepository {

    override suspend fun insertMessages(messages: List<Message>) = messageDao.insertMessages(messages)

    override suspend fun insertMessage(message: Message) = messageDao.insertMessage(message)

    override suspend fun getMessages(): Flow<List<Message>> = messageDao.getMessages()

    override suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>> = messageDao.getMessagesFromChat(chatId)

    override suspend fun deleteMessage(id: Long) = messageDao.deleteMessage(id)

    override suspend fun deleteMessagesFromChat(chatId: Long) = messageDao.deleteMessagesFromChat(chatId)

    override suspend fun deleteMessages(messageIds: List<Long>) = messageDao.deleteMessages(messageIds)

    override suspend fun updateMessages(messages: List<Message>) {
        deleteMessages(messages.map { it.id.orZero() })
        insertMessages(messages)
    }

    override suspend fun sendRequest(apiRequest: ApiRequest) = flow {
        val httpResponse = apiService.sendRequest(apiRequest)
        emit(httpResponse.handleResponse<ApiResponse>())
    }

    override fun getTest(): TestClass {
        val testClass = TestClass()
        testClass.testValue = "Test Value from MessageRepositoryImpl"
        return testClass
    }
}