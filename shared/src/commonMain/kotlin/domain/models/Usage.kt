package domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usage(
    @SerialName("prompt_tokens") val promptTokens: String?,
    @SerialName("completion_tokens") val completionTokens: String?,
    @SerialName("total_tokens") val totalTokens: String?,
)