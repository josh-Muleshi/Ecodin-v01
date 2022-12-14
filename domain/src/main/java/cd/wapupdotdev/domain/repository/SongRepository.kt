package cd.wapupdotdev.domain.repository

import cd.wapupdotdev.domain.entity.Song
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result

interface SongRepository {
    fun findSong(): Flow<Result<Song?>>
}