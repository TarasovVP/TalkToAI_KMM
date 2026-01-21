package data.database.db_entities

import domain.CommonExtensions.EMPTY
import domain.Constants.DEFAULT_CHAT_ID
import kotlinx.serialization.Serializable

@Serializable
data class Chat(
    var id: Long = DEFAULT_CHAT_ID,
    var name: String = String.EMPTY,
    var updated: Long = 0,
    var listOrder: Int = 0,
)