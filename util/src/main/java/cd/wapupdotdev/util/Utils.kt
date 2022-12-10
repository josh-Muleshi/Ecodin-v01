package cd.wapupdotdev.util

import com.google.firebase.FirebaseOptions
import org.ocpsoft.prettytime.PrettyTime
import java.util.*
import kotlin.random.Random

object Constant {
    object Firebase {
        const val TEST = "ecodim-test"
        const val LIVE = "ecodim-live"

        val TEST_CONFIG = FirebaseOptions.Builder()
            .setApplicationId("")
            .setProjectId("")
            .setApiKey("")
            .setApplicationId("")
            .setDatabaseUrl("")
            .build()

        val LIVE_CONFIG = FirebaseOptions.Builder()
            .setApplicationId("")
            .setProjectId("")
            .setApiKey("")
            .setApplicationId("")
            .setDatabaseUrl("")
            .build()
    }

    val isDebug: Boolean
        get() = BuildConfig.DEBUG

    object DefaultWebClientID {
        val DEBUG = ""//R.string.default_web_client_id_debug
        val RELEASE = ""//R.string.default_web_client_id_release
    }
}

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