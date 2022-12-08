plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "cd.wapupdotdev.domain"
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    api(project(":util"))
    api(Libs.koin_core)

    implementation(Libs.core_ktx)

    testImplementation(Libs.junit_jupiter_api)
    testImplementation(Libs.junit_jupiter_engine)

    testImplementation(Libs.mockk_core)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)

    implementation(Libs.timber)
}