package cd.wapupdotdev.util.extension

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import cd.wapupdotdev.i18n.R
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.net.toUri
import com.google.firebase.messaging.RemoteMessage
import cd.wapupdotdev.util.DeepLink

fun NotificationManager.createBeServedNotificationChannel(
  id: String,
  name: String,
  channelDescription: String
) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    val importance = NotificationManager.IMPORTANCE_HIGH
    val channel = NotificationChannel(id, name, importance).apply {
      description = channelDescription
    }
    createNotificationChannel(channel)
  }
}

fun NotificationManagerCompat.sendNotification(
  context: Context,
  channelId: String,
  notificationGroup: String,
  remoteMessage: RemoteMessage,
) {
  val deepLinkIntent = Intent(Intent.ACTION_VIEW).apply {
    data = "${DeepLink.baseUri}/${remoteMessage.data["link"]}".toUri()
    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
  }
  val deepLinkPendingIntent = TaskStackBuilder.create(context).run {
    addNextIntentWithParentStack(deepLinkIntent)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
      } else {
        getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
      }
  }

  val largeIcon = BitmapFactory.decodeResource(context.resources, R.drawable.ecodim_logo)
  val style = NotificationCompat.BigTextStyle()
    .bigText(remoteMessage.data["message"])

  val notificationId = (System.currentTimeMillis() / 1000L % Int.MAX_VALUE).toInt()
  val builder = NotificationCompat.Builder(context, channelId)
    .setSmallIcon(R.drawable.ecodim_logo)
    .setLargeIcon(largeIcon)
    .setContentTitle(remoteMessage.data["title"])
    .setContentText(remoteMessage.data["message"])
    .setStyle(style)
    .setAutoCancel(true)
    .setGroup(notificationGroup)
    .setSortKey(notificationId.toString())
    .setPriority(NotificationCompat.PRIORITY_MAX)
    .setContentIntent(deepLinkPendingIntent)

  notify(notificationId, builder.build())
}
