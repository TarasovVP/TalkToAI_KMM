import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class PlatformCoroutineDispatcher actual constructor() {
    actual val io: CoroutineDispatcher = Dispatchers.IO
    actual val main: CoroutineDispatcher = Dispatchers.Main
    actual val default: CoroutineDispatcher = Dispatchers.Default
}