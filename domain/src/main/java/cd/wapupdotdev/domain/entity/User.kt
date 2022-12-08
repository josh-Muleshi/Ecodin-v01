package cd.wapupdotdev.domain.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val imageUrl: String = "",
    @ServerTimestamp val createAt: Date? = null
)