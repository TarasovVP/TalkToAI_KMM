package data.database.dao

import app.cash.sqldelight.async.coroutines.awaitAsList
import data.database.SharedDatabase
import data.database.db_entities.Message
import domain.enums.MessageStatus
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class MessageDaoImpl(private val appDatabase: SharedDatabase): MessageDao {

        override suspend fun insertMessages(messages: List<Message>) {
            appDatabase { db ->
                db.appDatabaseQueries.transaction {
                    messages.forEach { message ->
                        db.appDatabaseQueries.insertMessage(
                            message.id,
                            message.chatId,
                            message.author,
                            message.message,
                            message.updatedAt,
                            message.status?.name,
                            message.errorMessage,
                            if (message.truncated) 1 else 0
                        )
                    }
                }
            }
        }

        override suspend fun insertMessage(message: Message) {
            appDatabase { db ->
                db.appDatabaseQueries.insertMessage(
                    message.id,
                    message.chatId,
                    message.author,
                    message.message,
                    message.updatedAt,
                    message.status?.name,
                    message.errorMessage,
                    if (message.truncated) 1 else 0
                )
            }
        }

        override suspend fun deleteMessages(messageIds: List<Long>) {
            appDatabase { db ->
                db.appDatabaseQueries.transaction {
                    messageIds.forEach { messageId ->
                        db.appDatabaseQueries.deleteMessage(messageId)
                    }
                }
            }
        }

        override suspend fun getMessages(): Flow<List<Message>> = callbackFlow {
            appDatabase { db ->
                trySend(db.appDatabaseQueries.getMessages().awaitAsList().map { message ->
                    Message(
                        message.id,
                        message.chatId,
                        message.author,
                        message.message,
                        message.updatedAt,
                        MessageStatus.valueOf(message.status.orEmpty()),
                        message.errorMessage,
                        message.truncated == 1L
                    )
                }).isSuccess
                awaitClose {  }
            }
        }

        override suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>> = callbackFlow {
            appDatabase { db ->
                trySend(db.appDatabaseQueries.getMessagesFromChat(chatId).awaitAsList().map { message ->
                    Message(
                        message.id,
                        message.chatId,
                        message.author,
                        message.message,
                        message.updatedAt,
                        MessageStatus.valueOf(message.status.orEmpty()),
                        message.errorMessage,
                        message.truncated == 1L
                    )
                }).isSuccess
                awaitClose {  }
            }
        }

    override suspend fun deleteMessagesFromChat(chatId: Long) {
        appDatabase { db ->
            db.appDatabaseQueries.deleteMessagesFromChat(chatId)
        }
    }

    override suspend fun deleteMessage(id: Long) {
        appDatabase { db ->
            db.appDatabaseQueries.deleteMessage(id)
        }
    }
}