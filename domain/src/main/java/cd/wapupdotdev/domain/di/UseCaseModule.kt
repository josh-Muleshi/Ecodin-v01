package cd.wapupdotdev.domain.di

import cd.wapupdotdev.domain.repository.SongRepository
import cd.wapupdotdev.util.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideSongUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: SongRepository
    ){

    }
}