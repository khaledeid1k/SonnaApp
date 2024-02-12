package com.sonna

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sonna.common.routes.Screens
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.screens.content.contentRoute
import com.sonna.screens.details.detailsRoute
import com.sonna.screens.home.homeRoute
import com.sonna.screens.setting.settingRoute
import com.sonna.screens.splash.splashRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SonnaApp(
    navController: NavHostController = rememberNavController()
) {
    SonnaAppTheme {
        Scaffold {
            AppNavGraph(navController = navController)
        }
    }
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        splashRoute(navController)
        homeRoute(navController)
        contentRoute(navController)
        detailsRoute(navController)
        settingRoute(navController)
    }
}

