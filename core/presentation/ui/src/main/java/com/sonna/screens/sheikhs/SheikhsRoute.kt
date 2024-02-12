package com.sonna.screens.sheikhs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.routes.Screens

private val ROUTE = Screens.SheikhsScreen.route
fun NavController.navigateToSheikhs() {
    navigate(ROUTE)
}

fun NavGraphBuilder.sheikhsRoute(navController: NavController) {
    composable(ROUTE) { SheikhsScreen(navController) }
}