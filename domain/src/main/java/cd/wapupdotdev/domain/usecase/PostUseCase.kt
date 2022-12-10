package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.Post
import cd.wapupdotdev.domain.repository.PostRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllPostUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    val repository: PostRepository
): FlowUseCase<Unit, List<Post>>(coroutineDispatcher) {
    override fun execute(parameters: Unit): Flow<Result<List<Post>>> {
        return repository.fetchAllPost()
    }
}

class FindPostByUidUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    val repository: PostRepository
): FlowUseCase<String, Post>(coroutineDispatcher){

    override fun execute(parameters: String): Flow<Result<Post>> {
        return repository.findPostByUid(
            uidPost = parameters
        )
    }
}