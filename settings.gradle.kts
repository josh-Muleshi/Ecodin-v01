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
        id("com.android.library") version "7.3.1"
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
include(":data")
include(":domain")
include(":util")
include(":i18n")
include(":ui-auth")
include(":ui-common")
include(":ui-home")
include(":ui-navigation")
include(":ui-onboarding")
