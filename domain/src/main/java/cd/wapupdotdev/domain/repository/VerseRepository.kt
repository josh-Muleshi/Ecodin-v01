package cd.wapupdotdev.domain.repository

import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result

interface VerseRepository {
    fun findVerse():Flow<Result<VerseRepository>>
}