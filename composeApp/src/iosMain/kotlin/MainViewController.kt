import androidx.compose.ui.window.ComposeUIViewController
import data.repositoryimpls.MessageRepositoryImpl
import domain.repositories.MessageRepository
import org.koin.core.Koin
import org.koin.core.component.getScopeName
import platform.UIKit.UIViewController

fun MainViewController(anyObject: Any): UIViewController {

    /*val platformMessageDisplayer = PlatformMessageDisplayer()
    val messageState: MutableState<String> = remember { mutableStateOf("") }*/
    val platformMessageDisplayer = PlatformMessageDisplayer()
    var onMessageDisplay: (String) -> Unit = {}
    val messageRepository = anyObject as Koin
    val viewController = ComposeUIViewController {
        /*if (messageRepositoryComponent == null) {
            error = "MessageRepositoryComponent is null"
        } else {
            val messageRepository = messageRepositoryComponent.messageRepository()
            if (messageRepository == null) {
                error = "MessageRepository is null"
            } else {
                App(messageRepository, onMessageDisplay = onMessageDisplay)
            }
        }*/
        App(onMessageDisplay = onMessageDisplay)
    }
    platformMessageDisplayer.setUIViewController(viewController)

    onMessageDisplay = { message ->
        var error = messageRepository.toString()
        /*try {
            val messageRepositoryComponent = KoinHelper().getMessageRepository()
            error = messageRepositoryComponent.toString()
        } catch (e: Exception) {
            error = e.message.toString()
        }*/
        platformMessageDisplayer.showPopupMessage(error)
        //if (message.isNotEmpty()) platformMessageDisplayer.showPopupMessage(message)
    }
    /*platformMessageDisplayer.setUIViewController(viewController)
    LaunchedEffect(messageState.value) {
        if (messageState.value.isNotEmpty()) platformMessageDisplayer.showPopupMessage(messageState.value)
    }*/
    return viewController
}