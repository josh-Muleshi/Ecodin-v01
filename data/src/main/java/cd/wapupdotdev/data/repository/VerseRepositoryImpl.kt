package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.verse.VerseDataSource
import cd.wapupdotdev.domain.entity.Verse
import cd.wapupdotdev.domain.repository.VerseRepository
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VerseRepositoryImpl @Inject constructor(
    private val dataSource: VerseDataSource
): VerseRepository{
    override fun findVerse(): Flow<Result<Verse?>> {
        return dataSource.findVerse()
    }
}