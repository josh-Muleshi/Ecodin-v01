package cd.wapupdotdev.util

import org.ocpsoft.prettytime.PrettyTime
import java.util.*
import kotlin.random.Random

object DateUtil {
    fun formatToMediumDate(date: Date?): String {
        return date?.run { PrettyTime().format(date) } ?: "∙∙"
    }

    fun formatMinute(value: Int): String {
        val date = Date(0)
        date.minutes = value
        if (value % 60 >= 30) {
            date.minutes += 60 - (value % 60)
        }
        val prettyTime = PrettyTime(Date(0))
        val duration = prettyTime.calculatePreciseDuration(date).first()
        return prettyTime.format(duration)
    }
}

fun generateShortCode(length: Int = 5): String {
    val characters = ('A'..'Z').toList()
    val numbers = ('0'..'9').toList()
    val input = characters + numbers
    return buildString {
        append("REF-")
        repeat(length) {
            val randomIndex = Random.nextInt(input.size)
            append(input[randomIndex])
        }
    }
}