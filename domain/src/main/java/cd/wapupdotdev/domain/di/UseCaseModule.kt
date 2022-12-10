package cd.wapupdotdev.domain.di

import cd.wapupdotdev.domain.repository.*
import cd.wapupdotdev.domain.usecase.*
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
    ): FindSongUseCase {
        return FindSongUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideVerseUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: VerseRepository
    ): FindVerseUseCase{
        return FindVerseUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideCommentUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: CommentRepository
    ): FetchAllCommentUseCase {
        return FetchAllCommentUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideAddCommentUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: CommentRepository
    ): AddCommentUseCase{
        return AddCommentUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindCurrentUserUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): FindCurrentUserUseCase {
        return FindCurrentUserUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindCurrentUserAsyncUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): FindCurrentUserAsyncUseCase {
        return FindCurrentUserAsyncUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSignInWithEmailAndPasswordUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SignInWithEmailAndPasswordUseCase {
        return SignInWithEmailAndPasswordUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideResentVerificationEmailUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): ResentVerificationEmailUseCase {
        return ResentVerificationEmailUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSignUpWithEmailAndPasswordUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SignUpWithEmailAndPasswordUseCase {
        return SignUpWithEmailAndPasswordUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSignInWithEmailAndLinkUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SignInWithEmailAndLinkUseCase {
        return SignInWithEmailAndLinkUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSendSignInLinkToEmail(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SendSignInLinkToEmailUseCase {
        return SendSignInLinkToEmailUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSignInWithAuthCredentialUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SignInWithAuthCredentialUseCase {
        return SignInWithAuthCredentialUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideSaveUserInfoUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: UserRepository
    ): SaveUserInfoUseCase {
        return SaveUserInfoUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFetchAllPostUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: PostRepository
    ): FetchAllPostUseCase {
        return FetchAllPostUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindPostByUidUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: PostRepository
    ): FindPostByUidUseCase {
        return FindPostByUidUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindAllNotificationUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: NotificationRepository
    ): FindOrderNotificationsUseCase {
        return FindOrderNotificationsUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindGlobalNotificationsUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: NotificationRepository
    ): FindGlobalNotificationsUseCase {
        return FindGlobalNotificationsUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideFindUnSeenNotificationUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: NotificationRepository
    ): FindOrderUnSeenNotificationUseCase {
        return FindOrderUnSeenNotificationUseCase(dispatcher, repository)
    }

    @Provides
    @Singleton
    fun provideMarkNotificationAsSeenUseCase(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        repository: NotificationRepository
    ): MarkOrderNotificationAsSeenUseCase {
        return MarkOrderNotificationAsSeenUseCase(dispatcher, repository)
    }
}