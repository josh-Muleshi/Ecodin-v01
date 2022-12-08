package cd.wapupdotdev.domain.mapper

import cd.wapupdotdev.domain.mapper.Mapper
import com.google.firebase.auth.FirebaseUser
import cd.wapupdotdev.domain.entity.User
import java.util.*

class FirebaseUserMapper : Mapper<FirebaseUser, User> {
  override fun map(input: FirebaseUser): User {
    return User(
      uid = input.uid,
      name = input.displayName ?: "",
      email = input.email ?: "",
      createAt = Date(input.metadata?.creationTimestamp ?: System.currentTimeMillis()),
      imageUrl = input.photoUrl?.toString() ?: "",
    )
  }
}