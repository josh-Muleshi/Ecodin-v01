package cd.wapupdotdev.data.datasource.verse

import cd.wapupdotdev.domain.entity.Verse
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface VerseDataSource {
    fun findVerse(): Flow<Result<Verse?>>
}