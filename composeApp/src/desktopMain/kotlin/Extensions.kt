

import ui_models.MessageUIModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun List<MessageUIModel>?.clearCheckToAction() {
    this?.forEach { message ->
        message.isCheckedToDelete.value = false
    }
}

fun List<MessageUIModel>?.textToAction(): String {
    return this?.filter { it.isCheckedToDelete.value }
        ?.joinToString { "${it.author}: ${it.message} \n" }.orEmpty()
}

fun Date.dateToMilliseconds(): Long {
    return time / 1000
}

fun Long.millsSecondsToDateTime(): String {
    return SimpleDateFormat("dd-MM-yyyy, HH:mm:ss", Locale.getDefault()).format(Date(this))
}

fun Date.isDefineSecondsLater(seconds: Int, updated: Long): Boolean {
    return time + (seconds * 1000) < (updated * 1000)
}
