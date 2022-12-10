package cd.wapupdotdev.data.datasource.notification

import cd.wapupdotdev.domain.entity.Notification
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface NotificationDataSource {
    fun findAllByUidUser(uidUser: String): Flow<Result<List<Notification>>>
    suspend fun markAsSeen(notification: Notification)
    fun findUnSeen(uidUser: String): Flow<Result<List<Notification>>>
    fun findGlobal(): Flow<Result<List<Notification>>>
}