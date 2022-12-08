package cd.wapupdotdev.util.extension

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.toColorInt
import androidx.core.net.toUri
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import cd.wapupdotdev.i18n.R
import cd.wapupdotdev.i18n.R as i18nR
import android.os.Environment


fun Context.shareText(text: String) {
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val share = Intent.createChooser(intent, null)
    startActivity(share)
}

fun String.formatAsColorInt(): Int {
    return try {
        toColorInt()
    } catch (e: Exception) {
        Color.Unspecified.toArgb()
    }
}

fun Context.longToast(@StringRes idRes: Int) {
    Toast.makeText(this, idRes, Toast.LENGTH_SHORT).show()
}

fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = url.toUri()
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    } else {
        longToast(R.string.app_name)
    }
}

fun Context.getGoogleSignInClient(@StringRes clientId: Int): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(getString(clientId))
        .requestEmail()
        .build()
    return GoogleSignIn.getClient(this, gso)
}

fun Context.downloadTicket(link: String, filePath: String): Long {
    val request = DownloadManager.Request(Uri.parse(link))

    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        .setTitle("Be served")
        .setDescription(getString(i18nR.string.app_name))
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        .setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            filePath
        )
    val manager = this.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    return manager.enqueue(request)
}
