package com.sonna.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.routes.Screens

private val ROUTE = Screens.DetailsScreen.route
fun NavController.navigateToDetails() {
    navigate(ROUTE)
}

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(ROUTE) { DetailsScreen(navController) }
}