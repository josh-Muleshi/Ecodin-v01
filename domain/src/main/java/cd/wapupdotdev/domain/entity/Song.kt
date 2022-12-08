package cd.wapupdotdev.domain.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Song(
    val uid: String = "",
    val song: String = "",
    @ServerTimestamp val createAt: Date? = null
)
