package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.Notification
import cd.wapupdotdev.domain.repository.NotificationRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.usecase.CoroutineUseCase
import cd.wapupdotdev.util.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result
import javax.inject.Inject

class FindOrderNotificationsUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: NotificationRepository
) : FlowUseCase<String, List<Notification>>(coroutineDispatcher) {
    override fun execute(parameters: String): Flow<Result<List<Notification>>> {
        return repository.findAllByUidUser(parameters)
    }
}

class FindGlobalNotificationsUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: NotificationRepository
) : FlowUseCase<Unit, List<Notification>>(coroutineDispatcher) {
    override fun execute(parameters: Unit): Flow<Result<List<Notification>>> {
        return repository.findGlobal()
    }
}

class FindOrderUnSeenNotificationUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: NotificationRepository
) : FlowUseCase<String, List<Notification>>(coroutineDispatcher) {
    override fun execute(parameters: String): Flow<Result<List<Notification>>> {
        return repository.findUnSeen(parameters)
    }
}

class MarkOrderNotificationAsSeenUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: NotificationRepository
) : CoroutineUseCase<Notification, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Notification) {
        return repository.markAsSeen(parameters)
    }
}