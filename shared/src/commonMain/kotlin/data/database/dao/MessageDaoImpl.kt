package data.database.dao

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.vnstudio.talktoai.AppDatabaseQueries
import data.database.db_entities.Message
import domain.enums.MessageStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageDaoImpl(private val appDatabaseQueries: AppDatabaseQueries): MessageDao {

        override fun insertMessages(messages: List<Message>) {
            appDatabaseQueries.transaction {
                messages.forEach { message ->
                    appDatabaseQueries.insertMessage(
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

        override fun insertMessage(message: Message) {
            appDatabaseQueries.insertMessage(
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

        override fun deleteMessages(messageIds: List<Long>) {
            appDatabaseQueries.transaction {
                messageIds.forEach { messageId ->
                    appDatabaseQueries.deleteMessage(messageId)
                }
            }
        }

        override fun getMessages(): Flow<List<Message>> {
            return appDatabaseQueries.getMessages().asFlow().mapToList().map { messages ->
                messages.map { message ->
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
                }
            }
        }

        override fun getMessagesFromChat(chatId: Long): Flow<List<Message>> {
            return appDatabaseQueries.getMessagesFromChat(chatId).asFlow().mapToList().map { messages ->
                messages.map { message ->
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
                }
            }
        }

    override fun deleteMessagesFromChat(chatId: Long) {
        appDatabaseQueries.deleteMessagesFromChat(chatId)
    }

    override fun deleteMessage(id: Long) {
        appDatabaseQueries.deleteMessage(id)
    }
}