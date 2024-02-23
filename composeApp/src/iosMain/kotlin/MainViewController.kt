import androidx.compose.ui.window.ComposeUIViewController
import data.repositoryimpls.MessageRepositoryImpl
import domain.TestClass
import domain.repositories.MessageRepository
import org.koin.core.Koin
import org.koin.core.component.getScopeName
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {

    val platformMessageDisplayer = PlatformMessageDisplayer()
    var onMessageDisplay: (String) -> Unit = {}

    val viewController = ComposeUIViewController {
        App(onMessageDisplay = onMessageDisplay)
    }
    platformMessageDisplayer.setUIViewController(viewController)

    onMessageDisplay = { message ->
        platformMessageDisplayer.showPopupMessage(message)
    }
    return viewController
}