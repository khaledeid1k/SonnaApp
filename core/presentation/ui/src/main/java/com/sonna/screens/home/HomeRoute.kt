package com.sonna.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sonna.common.utils.AppDestinations

private val ROUTE = AppDestinations.HomeScreen.route
fun NavController.navigateToHome() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) { HomeScreen(navController) }
}