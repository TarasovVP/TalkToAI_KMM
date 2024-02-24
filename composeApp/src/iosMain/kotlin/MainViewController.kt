import androidx.compose.ui.window.ComposeUIViewController
import domain.repositories.MessageRepository
import org.koin.core.Koin
import org.koin.dsl.koinApplication
import platform.UIKit.UIViewController

fun MainViewController(obj: Any): UIViewController {

    val platformMessageDisplayer = PlatformMessageDisplayer()
    var onMessageDisplay: (String) -> Unit = {}

    val viewController = ComposeUIViewController {
        App(onMessageDisplay = onMessageDisplay)
    }
    platformMessageDisplayer.setUIViewController(viewController)

    onMessageDisplay = { message ->
        /*val koin = try {
            println("MainViewController koinApplication initialized")
            koinApplication().koin.getAll<Any>()
        } catch (e: Exception) {
            println("MainViewController koinApplication ${e.message}")
            null
        }*/
        val koin = try {
            obj as Koin
        } catch (e: Exception) {
            e.message
        }
        platformMessageDisplayer.showPopupMessage("isKoinInitialized: obj as Koin $koin")
    }
    return viewController
}