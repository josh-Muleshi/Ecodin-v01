package cd.wapupdotdev.data.datasource.post

import cd.wapupdotdev.domain.entity.Post
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    fun fetchAllPost(): Flow<Result<List<Post>>>
    fun findPostByUid(uidPost: String): Flow<Result<Post>>
}