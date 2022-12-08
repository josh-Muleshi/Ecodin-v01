package cd.wapupdotdev.domain.repository

import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.util.Result

interface SongRepository {
    fun FindSong(): Flow<Result<SongRepository>>
}