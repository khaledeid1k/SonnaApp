package com.sonna.screens.content

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sonna.common.routes.ContentArgs
import com.sonna.common.routes.Screens

private val ROUTE = Screens.ContentScreen.route
fun NavController.navigateToContent(tabIndex: Int) {
    navigate("$ROUTE/$tabIndex")
}

fun NavGraphBuilder.contentRoute(navController: NavController) {
    composable("$ROUTE/{${ContentArgs.TAB_INDEX_ARGS}}",
        arguments = listOf(
            navArgument(ContentArgs.TAB_INDEX_ARGS) { NavType.IntType }
        )) { ContentScreen(navController) }
}