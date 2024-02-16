package data.database.dao

import data.database.db_entities.Chat
import kotlinx.coroutines.flow.Flow

interface ChatDao {

    fun insertChats(chats: List<Chat>)

    fun insertChat(chat: Chat)

    fun deleteChats(chatIds: List<Long>)

    fun getChats(): Flow<List<Chat>>

    fun getLastUpdatedChat(): Flow<Chat?>

    fun getChatById(chatId: Long): Flow<Chat?>

    fun updateChat(chat: Chat)

    fun updateChats(chats: List<Chat>)

    fun deleteChat(chat: Chat)
}