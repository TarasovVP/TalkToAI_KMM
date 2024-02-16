package domain.models

import domain.CommonExtensions.EMPTY
import domain.Constants.SUCCESS_MESSAGE
import kotlinx.serialization.Serializable

@Serializable
data class InfoMessage(
    var message: String = String.EMPTY,
    var type: String = SUCCESS_MESSAGE,
)