plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

android {
    namespace = "cd.wapupdotdev.util"
    compileSdk = ConfigData.compileSdk
    buildToolsVersion = ConfigData.buildToolsVersion

    defaultConfig {
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    api(project(":i18n"))

    implementation(Libs.core_ktx)

    api(platform(Libs.firebase_bom))
    api(Libs.firebase_firestore)
    api(Libs.firebase_auth)
    api(Libs.firebase_messaging)

    api(Libs.google_maps_ktx)
    api(Libs.google_maps_utils_ktx)
    api(Libs.google_place_ktx)

    api(Libs.compose_ui_tooling_preview)
    api(Libs.compose_ui)

    api(Libs.play_service_core_ktx)
    api(Libs.play_service_auth)
    api(Libs.play_service_core)

    api(Libs.mavericks_core)

    api(Libs.prettytime)

    api(platform(Libs.kotlin_coroutine_bom))
    api(Libs.kotlin_coroutine_core)
    api(Libs.kotlin_coroutine_play_service)

    testImplementation(Libs.junit_jupiter_api)
    testImplementation(Libs.junit_jupiter_engine)

    testImplementation(Libs.mockk_core)

    api(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)

    api(Libs.timber)

    implementation(Libs.advanced_webview)
}