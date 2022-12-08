package cd.wapupdotdev.domain.repository

import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.domain.entity.Notification
import cd.wapupdotdev.util.Result

interface NotificationRepository {
  fun findAllByUidUser(uidUser: String): Flow<Result<List<Notification>>>
  suspend fun markAsSeen(notification: Notification)
  fun findUnSeen(uidUser: String): Flow<Result<List<Notification>>>
  fun findGlobal(): Flow<Result<List<Notification>>>
}