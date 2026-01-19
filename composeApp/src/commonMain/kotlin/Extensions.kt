import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import ui_models.MessageUIModel

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

fun Long.millsSecondsToDateTime(): String {
    val instant = Instant.fromEpochMilliseconds(this)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${
        localDateTime.dayOfMonth.toString().padStart(2, '0')
    }-${
        localDateTime.monthNumber.toString().padStart(2, '0')
    }-${localDateTime.year}, ${
        localDateTime.hour.toString().padStart(2, '0')
    }:${localDateTime.minute.toString().padStart(2, '0')}:${
        localDateTime.second.toString().padStart(2, '0')
    }"
}

fun Instant.isDefineSecondsLater(seconds: Int, updated: Long): Boolean {
    val targetTime = this.plus(seconds, kotlinx.datetime.DateTimeUnit.SECOND, TimeZone.UTC)
    val updatedTime = Instant.fromEpochSeconds(updated)
    return targetTime < updatedTime
}

