package com.sonna.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.sonna.common.routes.Screens

private val ROUTE = Screens.HomeScreen.route
fun NavController.navigateToHome(clearBackStack: Boolean = false) {
    navigate(ROUTE) {
        if (clearBackStack) {
            popUpTo(graph.id) {
                inclusive = true
            }
        }
    }
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) { HomeScreen(navController) }
}