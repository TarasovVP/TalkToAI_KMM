package domain.sealed_classes

sealed class Result<out T> {
    data class Success<T>(val data: T? = null) : Result<T>()
    data class Failure(val errorMessage: String? = null) : Result<Nothing>()
}
