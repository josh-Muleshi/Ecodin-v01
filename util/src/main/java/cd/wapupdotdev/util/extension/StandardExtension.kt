package cd.wapupdotdev.util.extension

import java.text.SimpleDateFormat
import java.util.*

val Long.formatAsLongNumber: String
    get() = when (this) {
        in 0..999 -> "$this"
        in 1000..999999 -> "${(this / 1000).toInt()}K"
        else -> "${this / 1000}M"
    }

val Boolean.toNumeric: Float
    get() = if (this) 1f else 0f


val Double.formatAsDistance: String
    get() {
        return when (this.toInt()) {
            in 0..999 -> String.format("%.1f m", this)
            else -> String.format("%.1f Km", (this / 1000))
        }
    }


fun Date.getFormattedDate(format: String): String? {
    return try {
        SimpleDateFormat(format, Locale.getDefault()).format(this)
    } catch (exp: Throwable) {
        null
    }
}

fun <T> MutableList<T>.toggle(item: T): List<T> {
    if (this.contains(item)) {
        this.remove(item)
    } else {
        this.add(item)
    }
    return this
}

fun String.notContains(value: String) = !this.contains(value)

