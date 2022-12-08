import de.fayard.refreshVersions.core.versionFor
import java.time.Instant

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("io.github.reactivecircus.app-versioning") version "1.0.0"
    kotlin("android")
    kotlin("kapt")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

kapt {
    correctErrorTypes = true
    javacOptions {
        option("-Adagger.fastInit=ENABLED")
        option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
    }
}

appVersioning {
    overrideVersionCode { _, _, _ ->
        Instant.now().epochSecond.toInt()
    }
    overrideVersionName { gitTag, _, _ ->
        gitTag.rawTagName
    }
}

android {
    compileSdk = ConfigData.compileSdk
    buildToolsVersion = ConfigData.buildToolsVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release")  {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

        }
        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.compiler)
        //kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources {
            excludes += "META-INF/AL2.0"
            excludes += "META-INF/licenses/ASM"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
            excludes += "META-INF/LGPL2.1"
            excludes += "win32-x86/attach_hotspot_windows.dll"
            excludes += "win32-x86-64/attach_hotspot_windows.dll"
        }
    }
}

dependencies {

    implementation(Libs.core_ktx)
    implementation(Libs.compose_ui)
    implementation(Libs.compose_material)
    implementation(Libs.compose_ui_tooling_preview)
    implementation(Libs.lifecycle_runtime_ktx)
    implementation(Libs.activity_compose)
    testImplementation (Libs.junit4)
    androidTestImplementation (Libs.androidx_test_ext_junit)
    androidTestImplementation (Libs.compose_ui_test_junit4)
    debugImplementation(Libs.compose_ui_tooling)
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.1.0-beta01")

    implementation (platform(Libs.firebase_bom))
    implementation (Libs.firebase_firestore)
    implementation (Libs.firebase_auth)
    implementation (Libs.firebase_storage)

    implementation (Libs.kotlin_coroutine_android)
    implementation (Libs.kotlin_coroutine_play_service)

    implementation (Libs.hilt_android)
    kapt (Libs.hilt_android_compiler)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation(Libs.navigation_compose)
    implementation (Libs.accompanist_permissions)
    implementation (Libs.accompanist_insets)

    implementation (Libs.preference_ktx)

    implementation ("com.github.skydoves:landscapist-glide:1.5.0")
    implementation(Libs.accompanist_swiperefresh)
}