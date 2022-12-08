package cd.wapupdotdev.domain.repository

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import cd.wapupdotdev.domain.entity.User
import cd.wapupdotdev.util.Result

interface UserRepository {
  fun findCurrentUser(uidUser: String): Flow<Result<User?>>
  suspend fun findCurrentUserAsync(uidUser: String): User?
  suspend fun signInWithCredential(credential: AuthCredential): FirebaseUser
  suspend fun signInWithEmailAndPassword(email: String, password: String): FirebaseUser
  suspend fun signUpWithEmailAndPassword(email: String, password: String): FirebaseUser
  suspend fun saveUserInfo(user: User)
  suspend fun resentVerificationEmail()
  suspend fun sendSignInLinkToEmail(email: String)
  suspend fun signInWithEmailLink(email: String, link: String): FirebaseUser
}