package cd.wapupdotdev.domain.usecase

import cd.wapupdotdev.domain.entity.User
import cd.wapupdotdev.domain.repository.UserRepository
import cd.wapupdotdev.util.IoDispatcher
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.usecase.CoroutineUseCase
import cd.wapupdotdev.util.usecase.FlowUseCase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindCurrentUserUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : FlowUseCase<String, User?>(coroutineDispatcher) {
    override fun execute(parameters: String): Flow<Result<User?>> {
        return repository.findCurrentUser(parameters)
    }
}

class FindCurrentUserAsyncUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<String, User?>(coroutineDispatcher) {
    override suspend fun execute(parameters: String): User? {
        return repository.findCurrentUserAsync(parameters)
    }
}


class SignInWithEmailAndPasswordUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<SignInWithEmailAndPasswordUseCase.Param, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameters: Param) {
        repository.signInWithEmailAndPassword(
            email = parameters.emailAddress,
            password = parameters.password
        )
    }

    data class Param(val emailAddress: String, val password: String)
}

class ResentVerificationEmailUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<Unit, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameters: Unit) {
        repository.resentVerificationEmail()
    }
}

class SignInWithEmailAndLinkUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<SignInWithEmailAndLinkUseCase.Param, FirebaseUser>(coroutineDispatcher) {
    override suspend fun execute(parameters: Param): FirebaseUser {
        return repository.signInWithEmailLink(
            email = parameters.emailAddress,
            link = parameters.link
        )
    }

    data class Param(val emailAddress: String, val link: String)
}

class SendSignInLinkToEmailUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<String, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameters: String) {
        return repository.sendSignInLinkToEmail(
            email = parameters,
        )
    }
}

class SignUpWithEmailAndPasswordUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<SignUpWithEmailAndPasswordUseCase.Param, FirebaseUser>(coroutineDispatcher) {
    override suspend fun execute(parameters: Param): FirebaseUser {
        return repository.signUpWithEmailAndPassword(
            email = parameters.emailAddress,
            password = parameters.password
        )
    }

    data class Param(val emailAddress: String, val password: String)
}

class SaveUserInfoUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<User, Unit>(coroutineDispatcher) {
    override suspend fun execute(parameters: User) {
        return repository.saveUserInfo(parameters)
    }
}

class SignInWithAuthCredentialUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : CoroutineUseCase<AuthCredential, FirebaseUser>(coroutineDispatcher) {
    override suspend fun execute(parameters: AuthCredential): FirebaseUser {
        return repository.signInWithCredential(parameters)
    }
}