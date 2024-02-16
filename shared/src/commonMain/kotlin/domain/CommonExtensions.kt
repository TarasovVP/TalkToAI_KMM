package domain

import domain.sealed_classes.Result
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

object CommonExtensions {

    suspend inline fun <reified T> HttpResponse?.handleResponse(): Result<T> {
        return when {
            this == null -> Result.Failure("Unknown error")
            status.value !in 200..299 -> {
                val error = bodyAsText()
                Result.Failure(error)
            }

            else -> {
                try {
                    val result = body<T>()
                    Result.Success(result)
                } catch (e: Exception) {
                    Result.Failure(e.message)
                }
            }
        }
    }

    val String.Companion.EMPTY: String
        get() = ""

    fun Any?.isNull() = this == null

    fun Any?.isNotNull() = this != null

    fun Boolean?.isTrue() = this == true

    fun Boolean?.isNotTrue() = this != true

    fun Long?.orZero() = this ?: 0

}