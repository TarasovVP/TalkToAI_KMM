import androidx.compose.ui.window.ComposeUIViewController
import chat.ChatScreen
import chat.ChatViewModel
import platform.UIKit.UIViewController

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