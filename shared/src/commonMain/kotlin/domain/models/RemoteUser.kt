package domain.models

import data.database.db_entities.Chat
import data.database.db_entities.Message
import kotlinx.serialization.Serializable

@Serializable
data class RemoteUser(
    var chats: ArrayList<Chat> = arrayListOf(),
    var messages: ArrayList<Message> = arrayListOf(),
    var isReviewVoted: Boolean = false,
)