package usecaseimpls

import data.database.db_entities.Chat
import data.database.db_entities.Message
import domain.ApiRequest
import domain.Constants.DEFAULT_CHAT_ID
import domain.repositories.ChatRepository
import domain.repositories.MessageRepository
import domain.usecases.ChatUseCase
import kotlinx.coroutines.flow.Flow

class ChatUseCaseImpl(
    private val chatRepository: ChatRepository,
    private val messageRepository: MessageRepository,
) : ChatUseCase {

    override suspend fun insertChat(chat: Chat) = chatRepository.insertChat(chat)

    override suspend fun getCurrentChat(chatId: Long): Flow<Chat?> {
        return when (chatId) {
            DEFAULT_CHAT_ID -> chatRepository.getLastUpdatedChat()
            else -> chatRepository.getChatById(chatId)
        }
    }

    override suspend fun insertMessage(messageUIModel: Message) {
        messageRepository.insertMessage(messageUIModel)
    }


    override suspend fun deleteMessages(messageIds: List<Long>) =
        messageRepository.deleteMessages(messageIds)

    override suspend fun getMessagesFromChat(chatId: Long): Flow<List<Message>> =
        messageRepository.getMessagesFromChat(chatId)

    override suspend fun sendRequest(apiRequest: ApiRequest) =
        messageRepository.sendRequest(apiRequest)

}