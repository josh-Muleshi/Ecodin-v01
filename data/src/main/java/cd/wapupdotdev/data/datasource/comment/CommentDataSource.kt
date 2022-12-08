package cd.wapupdotdev.data.datasource.comment

import cd.wapupdotdev.domain.entity.Comment
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result

interface CommentDataSource {
    fun getAllComment(): Flow<Result<List<Comment>>>
}