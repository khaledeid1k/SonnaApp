package com.sonna.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.utils.AppDestinations

private val ROUTE = AppDestinations.DetailsScreen.route
fun NavController.navigateToDetails() {
    navigate(ROUTE)
}

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(ROUTE) { DetailsScreen(navController) }
}