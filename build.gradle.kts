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
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}