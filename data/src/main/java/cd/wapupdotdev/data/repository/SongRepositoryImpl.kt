package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.song.SongDataSource
import cd.wapupdotdev.domain.entity.Song
import cd.wapupdotdev.domain.repository.SongRepository
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val dataSource: SongDataSource
): SongRepository{
    override fun findSong(): Flow<Result<Song?>> {
        return dataSource.findSong()
    }
}