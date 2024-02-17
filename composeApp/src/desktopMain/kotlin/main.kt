import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import domain.repositories.MessageRepository
import org.koin.java.KoinJavaComponent.inject
import javax.swing.JOptionPane


fun main() = application {
    doInitKoin()
    val messageRepository: MessageRepository by inject(MessageRepository::class.java)
    Window(onCloseRequest = ::exitApplication, title = "Talk To AI") {
        App(messageRepository) { message ->
            JOptionPane.showMessageDialog(null, message)
        }
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}