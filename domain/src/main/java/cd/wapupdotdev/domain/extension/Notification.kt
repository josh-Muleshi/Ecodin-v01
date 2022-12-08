package cd.wapupdotdev.domain.extension

import cd.wapupdotdev.domain.entity.Notification

fun Map<String, String>.isValidNotificationData(): Boolean {
  return containsKey(Notification::title.name) &&
      containsKey(Notification::message.name) &&
      containsKey(Notification::type.name) &&
      containsKey(Notification::statusCode.name) &&
      containsKey(Notification::topic.name) &&
      containsKey(Notification::link.name)
}