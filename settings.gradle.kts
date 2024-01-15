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
include(":core:domain")
include(":core:data:local")
include(":core:data:remote")
include(":core:data:repository")
include(":core:presentation:ui")
include(":core:presentation:viewmodel")
include(":adminapp")
include(":common")
include(":administrator:data")
include(":administrator:presentation")
include(":administrator:domain")
include(":messenger:data:local")
include(":messenger:data:remote")
include(":messenger:data:repository")
include(":messenger:presentation:ui")
include(":messenger:presentation:viewmodel")
include(":auth:data:local")
include(":auth:data:remote")
include(":auth:data:repository")
include(":auth:domain")
include(":auth:presentation:ui")
include(":auth:presentation:viewmodel")
include(":messenger:domain")
