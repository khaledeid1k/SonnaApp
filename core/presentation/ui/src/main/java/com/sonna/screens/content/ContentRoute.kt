package com.sonna.screens.content

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.utils.AppDestinations

private val ROUTE = AppDestinations.ContentScreen.route
fun NavController.navigateToContent() {
    navigate(ROUTE)
}

fun NavGraphBuilder.contentRoute(navController: NavController) {
    composable(ROUTE) { ContentScreen(navController) }
}