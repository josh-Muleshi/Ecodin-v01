package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.Verse
import cd.wapupdotdev.domain.repository.VerseRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindVerseUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    val repository: VerseRepository
): FlowUseCase<Unit, Verse?>(coroutineDispatcher){
    override fun execute(parameters: Unit): Flow<Result<Verse?>> {
        return repository.findVerse()
    }
}