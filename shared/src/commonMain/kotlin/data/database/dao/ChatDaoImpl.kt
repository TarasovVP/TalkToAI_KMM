package data.database.dao

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import com.vnstudio.talktoai.AppDatabaseQueries
import data.database.db_entities.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatDaoImpl(private val appDatabaseQueries: AppDatabaseQueries) : ChatDao {

    override fun insertChats(chats: List<Chat>) {
        appDatabaseQueries.transaction {
            chats.forEach { chat ->
                appDatabaseQueries.insertChat(
                    chat.id,
                    chat.name,
                    chat.updated,
                    chat.listOrder.toLong()
                )
            }
        }
    }

    override fun insertChat(chat: Chat) {
        appDatabaseQueries.insertChat(
            chat.id,
            chat.name,
            chat.updated,
            chat.listOrder.toLong()
        )
    }

    override fun deleteChats(chatIds: List<Long>) {
        appDatabaseQueries.transaction {
            chatIds.forEach { chatId ->
                appDatabaseQueries.deleteChat(chatId)
            }
        }
    }

    override fun getChats(): Flow<List<Chat>> {
        return appDatabaseQueries.getChats().asFlow().mapToList().map { chats ->
            chats.map { chat ->
                Chat(
                    chat.id,
                    chat.name,
                    chat.updated,
                    chat.listOrder.toInt()
                )
            }
        }
    }

    override fun getLastUpdatedChat(): Flow<Chat?> {
        return appDatabaseQueries.getLastUpdatedChat().asFlow().mapToOneOrNull().map {
            it?.let {
                Chat(
                    it.id,
                    it.name,
                    it.updated,
                    it.listOrder.toInt()
                )
            }
        }
    }

    override fun getChatById(chatId: Long): Flow<Chat?> {
        return appDatabaseQueries.getChatById(chatId).asFlow().mapToOneOrNull().map {
            it?.let {
                Chat(
                    it.id,
                    it.name,
                    it.updated,
                    it.listOrder.toInt()
                )
            }
        }
    }

    override fun updateChat(chat: Chat) {
        appDatabaseQueries.updateChat(
            chat.name,
            chat.updated,
            chat.listOrder.toLong(),
            chat.id
        )
    }

    override fun updateChats(chats: List<Chat>) {
        appDatabaseQueries.transaction {
            chats.forEach { chat ->
                appDatabaseQueries.updateChat(
                    chat.name,
                    chat.updated,
                    chat.listOrder.toLong(),
                    chat.id
                )
            }
        }
    }

    override fun deleteChat(chat: Chat) {
        appDatabaseQueries.deleteChat(chat.id)
    }
}