package com.sonna.screens.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sonna.common.routes.DetailsArgs
import com.sonna.common.routes.Screens

private val ROUTE = Screens.DetailsScreen.route
fun NavController.navigateToDetails(tabIndex: Int, itemIndex: Int) {
    navigate("$ROUTE/$tabIndex/$itemIndex")
}

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable("$ROUTE/{${DetailsArgs.TAB_INDEX_ARGS}}/{${DetailsArgs.ITEM_INDEX_ARGS}}",
        arguments = listOf(
            navArgument(DetailsArgs.TAB_INDEX_ARGS) { NavType.IntType },
            navArgument(DetailsArgs.ITEM_INDEX_ARGS) { NavType.IntType }
        )
    ) { DetailsScreen(navController) }
}