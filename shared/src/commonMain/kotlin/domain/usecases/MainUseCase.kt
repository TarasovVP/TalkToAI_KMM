package domain.usecases

import data.database.db_entities.Chat
import data.database.db_entities.Message
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    suspend fun insertChats(chats: List<Chat>)

    suspend fun insertMessages(messages: List<Message>)

    suspend fun getChats(): Flow<List<Chat>>

    suspend fun updateChats(chats: List<Chat>)

    suspend fun insertChat(chat: Chat)

    suspend fun updateChat(chat: Chat)

    suspend fun deleteChat(chat: Chat)

    suspend fun updateMessages(messages: List<Message>)
}