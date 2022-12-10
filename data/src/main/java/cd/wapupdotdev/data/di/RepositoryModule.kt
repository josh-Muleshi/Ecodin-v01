package cd.wapupdotdev.data.di

import cd.wapupdotdev.data.datasource.comment.CommentDataSource
import cd.wapupdotdev.data.datasource.notification.NotificationDataSource
import cd.wapupdotdev.data.datasource.post.PostDataSource
import cd.wapupdotdev.data.datasource.song.SongDataSource
import cd.wapupdotdev.data.datasource.user.UserDataSource
import cd.wapupdotdev.data.datasource.verse.VerseDataSource
import cd.wapupdotdev.data.repository.*
import cd.wapupdotdev.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCommentRepository(
        dataSource: CommentDataSource
    ): CommentRepository {
        return CommentRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideNotificationRepository(
        dataSource: NotificationDataSource
    ): NotificationRepository {
        return NotificationRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideSongRepository(
        dataSource: SongDataSource
    ): SongRepository{
        return SongRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideVerseRepository(
        dataSource: VerseDataSource
    ): VerseRepository{
        return VerseRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        dataSource: UserDataSource
    ): UserRepository{
        return UserRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providePostRepository(
        dataSource: PostDataSource
    ): PostRepository{
        return PostRepositoryImpl(dataSource)
    }
}