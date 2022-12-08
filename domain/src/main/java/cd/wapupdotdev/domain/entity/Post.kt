package cd.wapupdotdev.domain.entity

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Post(
    val uid: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val verse: String = "",
    val goal: String = "",
    val Body: String = "",
    val conclusion: String = "",
    @ServerTimestamp val createdAt: Date? = null,
)
