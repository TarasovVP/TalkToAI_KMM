package domain

import kotlinx.serialization.Serializable

@Serializable
data class ApiErrorResponse(
    val error: ApiError?,
)