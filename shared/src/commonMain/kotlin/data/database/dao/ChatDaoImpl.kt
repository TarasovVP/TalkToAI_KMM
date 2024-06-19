package data.database.dao

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import data.database.SharedDatabase
import data.database.db_entities.Chat
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ChatDaoImpl(private val appDatabase: SharedDatabase) : ChatDao {

    override suspend fun insertChats(chats: List<Chat>) {
        appDatabase { db ->
            db.appDatabaseQueries.transaction {
                chats.forEach { chat ->
                    db.appDatabaseQueries.insertChat(
                        chat.id,
                        chat.name,
                        chat.updated,
                        chat.listOrder.toLong()
                    )
                }
            }
        }
    }

    override suspend fun insertChat(chat: Chat) {
        appDatabase { db ->
            db.appDatabaseQueries.insertChat(
                chat.id,
                chat.name,
                chat.updated,
                chat.listOrder.toLong()
            )
        }
    }

    override suspend fun deleteChats(chatIds: List<Long>) {
        appDatabase { db ->
            db.appDatabaseQueries.transaction {
                chatIds.forEach { chatId ->
                    db.appDatabaseQueries.deleteChat(chatId)
                }
            }
        }
    }

    override suspend fun getChats(): Flow<List<Chat>> = callbackFlow {
        appDatabase { db ->
            trySend(db.appDatabaseQueries.getChats().awaitAsList().map { chat ->
                Chat(
                    chat.id,
                    chat.name,
                    chat.updated,
                    chat.listOrder.toInt()
                )
            }).isSuccess
            awaitClose { }
        }
    }

    override suspend fun getLastUpdatedChat(): Flow<Chat?> = callbackFlow {
        appDatabase { db ->
            trySend(db.appDatabaseQueries.getLastUpdatedChat().awaitAsOneOrNull()?.run {
                Chat(
                    id,
                    name,
                    updated,
                    listOrder.toInt()
                )
            }).isSuccess
            awaitClose { }
        }
    }

    override suspend fun getChatById(chatId: Long): Flow<Chat?> = callbackFlow {
        appDatabase { db ->
            trySend(db.appDatabaseQueries.getChatById(chatId).awaitAsOneOrNull()?.run {
                Chat(
                    id,
                    name,
                    updated,
                    listOrder.toInt()
                )
            }).isSuccess
            awaitClose { }
        }
    }

    override suspend fun updateChat(chat: Chat) {
        appDatabase { db ->
            db.appDatabaseQueries.updateChat(
                chat.name,
                chat.updated,
                chat.listOrder.toLong(),
                chat.id
            )
        }
    }

    override suspend fun updateChats(chats: List<Chat>) {
        appDatabase { db ->
            db.appDatabaseQueries.transaction {
                chats.forEach { chat ->
                    db.appDatabaseQueries.updateChat(
                        chat.name,
                        chat.updated,
                        chat.listOrder.toLong(),
                        chat.id
                    )
                }
            }
        }
    }

    override suspend fun deleteChat(chat: Chat) {
        appDatabase { db ->
            db.appDatabaseQueries.deleteChat(chat.id)
        }
    }
}