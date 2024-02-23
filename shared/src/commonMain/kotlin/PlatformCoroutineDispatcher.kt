import kotlinx.coroutines.CoroutineDispatcher

expect class PlatformCoroutineDispatcher() {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}