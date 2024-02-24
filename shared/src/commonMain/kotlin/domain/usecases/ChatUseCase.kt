package domain.usecases

import data.database.db_entities.Chat
import data.database.db_entities.Message
import domain.ApiRequest
import domain.ApiResponse
import domain.sealed_classes.Result
import kotlinx.coroutines.flow.Flow

interface ChatUseCase {

    suspend fun insertChat(chat: Chat)

    suspend fun getCurrentChat(chatId: Long): Flow<Chat?>

    suspend fun insertMessage(messageUIModel: Message)

    suspend fun deleteMessages(messageIds: List<Long>)

    suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>>

    suspend fun sendRequest(apiRequest: ApiRequest): Flow<Result<ApiResponse>>
}