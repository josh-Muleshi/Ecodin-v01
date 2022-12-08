import de.fayard.refreshVersions.core.versionFor

plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "cd.wapupdotdev.ui_common"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.compiler)
    }
}

dependencies {

    api(project(":data"))
    api(project(":util"))

    api(Libs.core_ktx)
    api(Libs.compose_compiler)
    api(Libs.compose_ui_tooling)
    api(Libs.compose_ui_tooling_preview)
    api(Libs.compose_ui)
    api(Libs.compose_ui_viewbinding)
    api(Libs.compose_material)
    api(Libs.compose_runtime_livedata)
    api(Libs.compose_material_icons_extended)
    api(Libs.compose_constraint_layout)

    api(Libs.coil_compose)

    api(Libs.accompanist_pager)
    api(Libs.accompanist_pager_indicators)
    api(Libs.accompanist_webview)
    api(Libs.accompanist_placeholder)
    api(Libs.accompanist_navigation_animation)
    api(Libs.accompanist_flowlayout)

    api(Libs.mavericks_compose)
    testApi(Libs.mavericks_testing)
    testApi(Libs.mavericks_mocking)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)

    testApi("junit:junit:4.13.2")
    androidTestApi("androidx.test.ext:junit:1.1.3")
    androidTestApi("androidx.test.espresso:espresso-core:3.4.0")
}