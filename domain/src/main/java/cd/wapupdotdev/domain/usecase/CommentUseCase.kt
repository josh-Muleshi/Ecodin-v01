package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.Comment
import cd.wapupdotdev.domain.repository.CommentRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.usecase.CoroutineUseCase
import cd.wapupdotdev.util.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllCommentUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val commentRepository: CommentRepository
): FlowUseCase<Unit, List<Comment?>>(coroutineDispatcher){
    override fun execute(parameters: Unit): Flow<Result<List<Comment?>>> {
        return commentRepository.fetchAllComment()
    }
}

class AddCommentUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val commentRepository: CommentRepository
): CoroutineUseCase<Comment, Unit>(coroutineDispatcher){
    override suspend fun execute(parameters: Comment) {
        return commentRepository.addComment(parameters)
    }
}