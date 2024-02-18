import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import domain.CommonExtensions.EMPTY
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {

    //val messageState: MutableState<String> = remember { mutableStateOf(String.EMPTY) }
    val viewController = ComposeUIViewController {
        App()
    }
    /*val platformMessageDisplayer = PlatformMessageDisplayer(viewController)
    LaunchedEffect(messageState.value) {
        if (messageState.value.isNotEmpty()) platformMessageDisplayer.showPopupMessage(messageState.value)
    }*/
    return viewController
}