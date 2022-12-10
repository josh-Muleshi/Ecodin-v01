package cd.wapupdotdev.domain.repository

import cd.wapupdotdev.domain.entity.Verse
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result

interface VerseRepository {
    fun findVerse():Flow<Result<Verse>>
}