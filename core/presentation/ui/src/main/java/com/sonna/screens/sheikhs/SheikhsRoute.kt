package com.sonna.screens.sheikhs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.utils.AppDestinations

private val ROUTE = AppDestinations.SheikhsScreen.route
fun NavController.navigateToSheikhs() {
    navigate(ROUTE)
}

fun NavGraphBuilder.sheikhsRoute(navController: NavController) {
    composable(ROUTE) { SheikhsScreen(navController) }
}