package cd.wapupdotdev.domain.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Comment(
    val uid: String = "",
    val userUid: String = "",
    val message: String = "",
    @ServerTimestamp val createAt: Date? = null
)