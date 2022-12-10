package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.comment.CommentDataSource
import cd.wapupdotdev.domain.entity.Comment
import cd.wapupdotdev.domain.repository.CommentRepository
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val dataSource: CommentDataSource
): CommentRepository {
    override fun fetchAllComment(): Flow<Result<List<Comment?>>> {
        return dataSource.getAllComment()
    }

    override suspend fun addComment(comment: Comment) {
        return dataSource.addComment(comment)
    }
}