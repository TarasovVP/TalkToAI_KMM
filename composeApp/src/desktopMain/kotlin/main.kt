import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.java.KoinJavaComponent.inject

fun main() {
    doInitKoin()
    val platformMessageDisplayer: PlatformMessageDisplayer by inject(PlatformMessageDisplayer::class.java)
    application {
        Window(onCloseRequest = ::exitApplication, title = "Talk To AI") {
            App { message ->
                if (message.isNotEmpty()) platformMessageDisplayer.showPopupMessage(message)
            }
        }
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}