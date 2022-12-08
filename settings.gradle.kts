pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("de.fayard.refreshVersions") version "0.51.0"
        id("com.android.application") version "7.2.2"
        id("org.jetbrains.kotlin.android") version "1.7.20"
    }
}
plugins {
    id("de.fayard.refreshVersions")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Ecodim"
include(":app")
include(":buildsrc")
