package com.sonna

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sonna.common.utils.AppDestinations
import com.sonna.screens.content.contentRoute
import com.sonna.screens.details.detailsRoute
import com.sonna.screens.home.homeRoute
import com.sonna.screens.setting.settingRoute
import com.sonna.screens.splash.splashRoute

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppDestinations.SplashScreen.route) {
        splashRoute(navController)
        homeRoute(navController)
        contentRoute(navController)
        detailsRoute(navController)
        settingRoute(navController)
    }
}