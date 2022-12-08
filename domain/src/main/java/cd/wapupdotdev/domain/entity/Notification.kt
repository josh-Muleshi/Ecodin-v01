package cd.wapupdotdev.domain.entity

import java.util.*

data class Notification(
  val uid: String = "",
  val createdAt: Date? = null,
  val seenAt: Date? = null,
  val title: String = "",
  val message: String = "",
  val type: String = "",
  val statusCode: Int = 0,
  val link: String = "",
  val topic: String = ""
)
