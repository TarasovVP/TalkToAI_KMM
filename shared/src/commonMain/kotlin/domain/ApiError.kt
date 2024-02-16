package domain

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val message: String?,
    val type: String?,
    val param: String?,
    val code: String?
)