val kspVersion: String by project

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Libs.kotlin_gradle_plugin)
        classpath(Libs.gradle_plugin)
        classpath(Libs.hilt_gradle_plugin)
        classpath(Libs.play_service_plugin)
    }
}
plugins {
    id ("com.android.application") version "7.2.2" apply false
    id ("com.android.library") version "7.2.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.5.31" apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}