import androidx.compose.ui.window.ComposeUIViewController
import chat.ChatScreen
import chat.ChatViewModel
import platform.UIKit.UIViewController

fun MainViewController(viewModel: ChatViewModel?): UIViewController {

    val platformMessageDisplayer = PlatformMessageDisplayer()
    var onMessageDisplay: (String) -> Unit = {}

    val viewController = ComposeUIViewController {
        viewModel?.let { ChatScreen(it, onMessageDisplay = onMessageDisplay) }
    }
    platformMessageDisplayer.setUIViewController(viewController)

    onMessageDisplay = { message ->
        platformMessageDisplayer.showPopupMessage("MainViewController: message $message")
    }
    return viewController
}