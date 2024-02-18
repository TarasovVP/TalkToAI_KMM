import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import domain.CommonExtensions.EMPTY
import domain.repositories.MessageRepository
import org.koin.java.KoinJavaComponent.inject

fun main()  {
    doInitKoin()
    val messageRepository: MessageRepository by inject(MessageRepository::class.java)
    val platformMessageDisplayer: PlatformMessageDisplayer by inject(PlatformMessageDisplayer::class.java)
    application {
        val messageState: MutableState<String> = remember { mutableStateOf(String.EMPTY) }
        LaunchedEffect(messageState.value) {
            if (messageState.value.isNotEmpty()) platformMessageDisplayer.showPopupMessage(messageState.value)
        }
        Window(onCloseRequest = ::exitApplication, title = "Talk To AI") {
            App(messageRepository, messageState)
        }
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}