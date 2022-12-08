package cd.wapupdotdev.util.compose

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark-MODE", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light-MODE", showBackground = true)
annotation class BeServedThemePreview
