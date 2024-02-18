import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyle
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIViewController

actual class PlatformMessageDisplayer(private val uiViewController: UIViewController) {

    actual fun showPopupMessage(message: String) {
        val alertController = UIAlertController.alertControllerWithTitle(
            title = "Message",
            message = message,
            preferredStyle = UIAlertControllerStyleAlert
        )
        alertController.addAction(
            UIAlertAction.actionWithTitle(
                title = "OK",
                style = UIAlertActionStyleDefault,
                handler = null
            )
        )
        uiViewController.presentViewController(alertController, animated = true, completion = null)
    }
}