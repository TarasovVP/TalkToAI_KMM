import ui_models.MessageUIModel
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

fun List<MessageUIModel>?.clearCheckToAction() {
    this?.forEach { message ->
        message.isCheckedToDelete.value = false
    }
}

fun List<MessageUIModel>?.textToAction(): String {
    return this?.filter { it.isCheckedToDelete.value }
        ?.joinToString { "${it.author}: ${it.message} \n" }.orEmpty()
}

fun Instant.dateToMilliseconds(): Long {
    return toEpochMilliseconds() / 1000
}

fun Instant.isDefineSecondsLater(seconds: Int, updatedSeconds: Long): Boolean {
    val targetTime = this + seconds.seconds
    val updatedTime = Instant.fromEpochSeconds(updatedSeconds)
    return targetTime < updatedTime
}

