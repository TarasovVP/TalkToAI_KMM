package data.database.dao

import data.database.db_entities.Chat
import kotlinx.coroutines.flow.Flow

interface ChatDao {

    suspend fun insertChats(chats: List<Chat>)

    suspend fun insertChat(chat: Chat)

    suspend fun deleteChats(chatIds: List<Long>)

    suspend fun getChats(): Flow<List<Chat>>

    suspend fun getLastUpdatedChat(): Flow<Chat?>

    suspend fun getChatById(chatId: Long): Flow<Chat?>

    suspend fun updateChat(chat: Chat)

    suspend fun updateChats(chats: List<Chat>)

    suspend fun deleteChat(chat: Chat)
}