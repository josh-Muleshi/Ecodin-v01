plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "cd.wapupdotdev.i18n"
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        minSdk = ConfigData.minSdk
    }
}

