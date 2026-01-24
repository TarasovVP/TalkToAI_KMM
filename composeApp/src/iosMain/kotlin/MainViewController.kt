import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import presentation.chat.ChatScreen
import presentation.chat.ChatViewModel

fun MainViewController(viewModel: ChatViewModel?): UIViewController {

    val platformMessageDisplayer = PlatformMessageDisplayer()
    var onMessageDisplay: (String) -> Unit = {}
    val viewController = ComposeUIViewController {
        ChatScreen(onMessageDisplay = onMessageDisplay)
    }
    platformMessageDisplayer.setUIViewController(viewController)

    onMessageDisplay = { message ->
        platformMessageDisplayer.showPopupMessage(message)
    }
    return viewController
}