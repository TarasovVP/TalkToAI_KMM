package domain.models

import domain.CommonExtensions.EMPTY
import kotlinx.serialization.Serializable

@Serializable
data class Feedback(
    var user: String = String.EMPTY,
    var message: String = String.EMPTY,
    var time: Long = 0,
)