package com.sonna.screens.setting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.routes.Screens

private val ROUTE = Screens.SettingScreen.route
fun NavController.navigateToSetting() {
    navigate(ROUTE)
}

fun NavGraphBuilder.settingRoute(navController: NavController) {
    composable(ROUTE) { SettingScreen(navController) }
}