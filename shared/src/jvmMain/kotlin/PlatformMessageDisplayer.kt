import javax.swing.JOptionPane


actual class PlatformMessageDisplayer {

    actual fun showPopupMessage(message: String) {
        JOptionPane.showMessageDialog(null, message)
    }
}