package cd.wapupdotdev.domain.repository

import cd.wapupdotdev.domain.entity.Comment
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun getComment(uidUser: String): Flow<Result<Comment?>>
    suspend fun addComment(uidComment: String, uidUser: String, name: String, message: String)
}