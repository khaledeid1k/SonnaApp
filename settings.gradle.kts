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
include(":core:domain")
include(":core:data:local")
include(":core:data:remote")
include(":core:data:repository")
include(":core:presentation:ui")
include(":core:presentation:viewmodel")
