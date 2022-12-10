package cd.wapupdotdev.data.di

import cd.wapupdotdev.data.R
import cd.wapupdotdev.util.Constant
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.Provides
import javax.inject.Singleton

@Provides
@Singleton
fun provideFirestore(): FirebaseFirestore {
    val name = if (Constant.isDebug) Constant.Firebase.TEST else Constant.Firebase.LIVE
    val app = FirebaseApp.getInstance(name)
    return FirebaseFirestore.getInstance(app)
}

@Provides
@Singleton
fun provideAuth(): FirebaseAuth {
    val name = if (Constant.isDebug) Constant.Firebase.TEST else Constant.Firebase.LIVE
    val app = FirebaseApp.getInstance(name)
    return FirebaseAuth.getInstance(app)
}

@Provides
@Singleton
fun provideFirebaseConfig(): FirebaseRemoteConfig {
    val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 0
    }
    return Firebase.remoteConfig.apply {
        setConfigSettingsAsync(configSettings)
        setDefaultsAsync(R.xml.remote_config_defaults)
    }
}
