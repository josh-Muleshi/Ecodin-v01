package cd.wapupdotdev.data.datasource.notification

import cd.wapupdotdev.domain.entity.Notification
import cd.wapupdotdev.util.extension.collectAsFlow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import cd.wapupdotdev.util.Result

class FirebaseNotificationDataSource @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : NotificationDataSource {

    override fun findAllByUidUser(uidUser: String): Flow<Result<List<Notification>>> {
        return firestore.collection("users/$uidUser/notifications")
            .orderBy(Notification::createdAt.name, Query.Direction.DESCENDING)
            .collectAsFlow()
    }

    override fun findUnSeen(uidUser: String): Flow<Result<List<Notification>>> {
        return firestore.collection("users/$uidUser/notifications")
            .orderBy(Notification::createdAt.name, Query.Direction.DESCENDING)
            .whereEqualTo(Notification::seenAt.name, null)
            .collectAsFlow()
    }

    override suspend fun markAsSeen(notification: Notification) {
        val uidUser = auth.currentUser?.uid ?: "non"
        firestore.document("users/$uidUser/notifications/${notification.uid}")
            .update(Notification::seenAt.name, Date())
            .await()
    }

    override fun findGlobal(): Flow<Result<List<Notification>>> {
        return firestore.collection("notifications")
            .orderBy(Notification::createdAt.name, Query.Direction.DESCENDING)
            .collectAsFlow()
    }
}
