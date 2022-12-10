package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.post.PostDataSource
import cd.wapupdotdev.domain.entity.Post
import cd.wapupdotdev.domain.repository.PostRepository
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val dataSource: PostDataSource
): PostRepository {
    override fun fetchAllPost(): Flow<Result<List<Post>>> {
        return dataSource.fetchAllPost()
    }

    override fun findPostByUid(uidPost: String): Flow<Result<Post>> {
        return dataSource.findPostByUid(uidPost)
    }
}