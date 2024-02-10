package com.sonna.common.utils

sealed class AppDestinations(val route: String) {
    data object SplashScreen : AppDestinations("SplashScreen")
    data object HomeScreen : AppDestinations("HomeScreen")
    data object ContentScreen : AppDestinations("ContentScreen")
    data object DetailsScreen : AppDestinations("DetailsScreen")
    data object SettingScreen : AppDestinations("SettingScreen")
    data object SheikhsScreen : AppDestinations("SheikhsScreen")
}



//data object CounterScreen : Screen("CounterScreen/{firstName}/{lastName}")
