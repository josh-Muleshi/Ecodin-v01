package cd.wapupdotdev.domain.repository

import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.domain.entity.Post

interface PostRepository {
    fun fetchAllPost(): Flow<Result<List<Post>>>
    fun findPostByUid(uidGroup: String, uidStore: String, uidPost: String): Flow<Result<Post>>
}