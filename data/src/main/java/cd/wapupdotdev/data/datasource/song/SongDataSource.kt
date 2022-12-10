package cd.wapupdotdev.data.datasource.song

import cd.wapupdotdev.domain.entity.Song
import cd.wapupdotdev.util.Result
import kotlinx.coroutines.flow.Flow

interface SongDataSource {
    fun findSong(): Flow<Result<Song?>>
}