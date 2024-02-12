package com.sonna.common.routes

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("SplashScreen")
    data object HomeScreen : Screens("HomeScreen")
    data object ContentScreen : Screens("ContentScreen")
    data object DetailsScreen : Screens("DetailsScreen")
    data object SettingScreen : Screens("SettingScreen")
    data object SheikhsScreen : Screens("SheikhsScreen")
}