package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.Song
import cd.wapupdotdev.domain.repository.SongRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindSongUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    val repository: SongRepository
): FlowUseCase<Unit, Song?>(coroutineDispatcher){
    override fun execute(parameters: Unit): Flow<Result<Song?>> {
        return repository.findSong()
    }
}