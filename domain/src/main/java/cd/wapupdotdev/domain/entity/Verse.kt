package cd.wapupdotdev.domain.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Verse(
    val uid: String = "",
    val verse: String = "",
    @ServerTimestamp val createAt: Date? = null
)
