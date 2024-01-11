pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sonna App"
include(":app")
include(":designsystem")
include(":messenger:data")
include(":messenger:presentation")
include(":messenger:domain")
include(":admin:presentation")
include(":admin:domain")
include(":admin:data")
include(":core:data")
include(":core:domain")
include(":core:presentation")
