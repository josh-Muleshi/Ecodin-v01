package cd.wapupdotdev.domain.repository

import cd.wapupdotdev.domain.entity.Comment
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun fetchAllComment(): Flow<Result<List<Comment>>>
    suspend fun addComment(comment: Comment)
}