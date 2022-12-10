package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.notification.NotificationDataSource
import cd.wapupdotdev.domain.entity.Notification
import cd.wapupdotdev.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
    private val dataSource: NotificationDataSource
) : NotificationRepository {
    override fun findAllByUidUser(uidUser: String): Flow<Result<List<Notification>>> {
        return dataSource.findAllByUidUser(uidUser)
    }

    override suspend fun markAsSeen(notification: Notification) {
        return dataSource.markAsSeen(notification)
    }

    override fun findUnSeen(uidUser: String): Flow<Result<List<Notification>>> {
        return dataSource.findUnSeen(uidUser)
    }

    override fun findGlobal(): Flow<Result<List<Notification>>> {
        return dataSource.findGlobal()
    }
}