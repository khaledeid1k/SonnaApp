package com.sonna.screens.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.utils.AppDestinations

private val ROUTE = AppDestinations.SplashScreen.route
fun NavController.navigateToSplash() {
    navigate(ROUTE)
}

fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable(ROUTE) { SplashScreen(navController) }
}