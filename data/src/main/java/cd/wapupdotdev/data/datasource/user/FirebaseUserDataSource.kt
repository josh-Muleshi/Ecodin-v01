package cd.wapupdotdev.data.datasource.user

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import cd.wapupdotdev.domain.entity.User
import cd.wapupdotdev.util.Result
import cd.wapupdotdev.util.extension.collectAsFlowNullable
import timber.log.Timber
import javax.inject.Inject

class FirebaseUserDataSource @Inject constructor(
  private val auth: FirebaseAuth,
  private val firestore: FirebaseFirestore
) : UserDataSource {
  override fun findCurrentUser(uidUser: String): Flow<Result<User?>> {
    return firestore.collection("users").document(uidUser).collectAsFlowNullable()
  }

  override suspend fun findCurrentUserAsync(uidUser: String): User? {
    val data = firestore.collection("users").document(uidUser).get().await()
    return data.toObject()
  }

  override suspend fun signInWithCredential(credential: AuthCredential): FirebaseUser {
    return try {
      auth.signInWithCredential(credential).await().user!!
    } catch (e: Exception) {
      Timber.e(e)
      error(e.localizedMessage ?: "")
    }
  }

  override suspend fun signInWithEmailAndPassword(email: String, password: String): FirebaseUser {
    return try {
      auth.signInWithEmailAndPassword(email, password).await().user!!
    } catch (e: Exception) {
      error(e.localizedMessage ?: "")
    }
  }

  override suspend fun signUpWithEmailAndPassword(email: String, password: String): FirebaseUser {
    return try {
      auth.createUserWithEmailAndPassword(email, password).await().user!!
      auth.currentUser!!
    } catch (e: Exception) {
      error(e.localizedMessage ?: "")
    }
  }

  override suspend fun saveUserInfo(user: User) {
    firestore.collection("users").document(user.uid).set(user).await()
  }

  override suspend fun sendSignInLinkToEmail(email: String) {
    try {
      val actionCodeSettings = actionCodeSettings {
        url = "https://wapupdotdev.com/verify"
        handleCodeInApp = true
        setIOSBundleId("cd.wapupdotdev..ios")
        setAndroidPackageName("cd.wapupdotdev.", true, "12")
      }
      auth.sendSignInLinkToEmail(email, actionCodeSettings).await()
    } catch (e: Exception) {
      error(e.localizedMessage ?: "")
    }
  }

  override suspend fun signInWithEmailLink(email: String, link: String): FirebaseUser {
    return try {
      auth.signInWithEmailLink(email, link).await().user!!
    } catch (e: Exception) {
      error(e.localizedMessage ?: "")
    }
  }

  override suspend fun resentVerificationEmail() {
    auth.currentUser?.sendEmailVerification()?.await()
  }
}