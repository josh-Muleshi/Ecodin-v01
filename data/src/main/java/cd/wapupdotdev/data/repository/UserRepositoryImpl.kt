package cd.wapupdotdev.data.repository

import cd.wapupdotdev.data.datasource.user.UserDataSource
import cd.wapupdotdev.domain.entity.User
import cd.wapupdotdev.domain.repository.UserRepository
import cd.wapupdotdev.util.Result
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {
    override fun findCurrentUser(uidUser: String): Flow<Result<User?>> {
        return dataSource.findCurrentUser(uidUser)
    }

    override suspend fun findCurrentUserAsync(uidUser: String): User? {
        return dataSource.findCurrentUserAsync(uidUser)
    }

    override suspend fun signInWithCredential(credential: AuthCredential): FirebaseUser {
        return dataSource.signInWithCredential(credential)
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): FirebaseUser {
        return dataSource.signInWithEmailAndPassword(email, password)
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): FirebaseUser {
        return dataSource.signUpWithEmailAndPassword(email, password)
    }

    override suspend fun saveUserInfo(user: User) {
        return dataSource.saveUserInfo(user)
    }

    override suspend fun resentVerificationEmail() {
        return dataSource.resentVerificationEmail()
    }

    override suspend fun sendSignInLinkToEmail(email: String) {
        return dataSource.sendSignInLinkToEmail(email)
    }

    override suspend fun signInWithEmailLink(email: String, link: String): FirebaseUser {
        return dataSource.signInWithEmailLink(email, link)
    }
}