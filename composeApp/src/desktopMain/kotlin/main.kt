import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import chat.ChatScreen
import di.doInitKoin
import domain.models.InfoMessage
import org.koin.java.KoinJavaComponent.inject
import resources.getStringResourcesByLocale
import java.util.Locale

fun main() {
    doInitKoin()
    val platformMessageDisplayer: PlatformMessageDisplayer by inject(PlatformMessageDisplayer::class.java)
    application {
        Window(onCloseRequest = ::exitApplication, title = "Talk To AI") {
            val isMessageDeleteModeState = remember { mutableStateOf<Boolean?>(null) }
            val infoMessageState = remember { mutableStateOf<InfoMessage?>(null) }
            val progressVisibilityState = remember { mutableStateOf(false) }
            val stringResource = getStringResourcesByLocale(Locale.getDefault().language)
            ChatScreen(
                1L,
                isMessageDeleteModeState,
                infoMessageState = infoMessageState,
                progressVisibilityState = progressVisibilityState,
                stringResource = stringResource,
            )
        }
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}