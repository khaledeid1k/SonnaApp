package com.sonna.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sonna.common.R
import com.sonna.common.composables.Title
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.routes.Screens
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.content.navigateToContent
import com.sonna.screens.details.navigateToDetails
import com.sonna.screens.home.composables.HomeCardItem
import com.sonna.screens.setting.navigateToSetting
import com.sonna.screens.sheikhs.navigateToSheikhs
import com.sonna.screens.splash.navigateToSplash
import com.sonna.viewmodel.home.HomeViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeContent(homeState = HomeState()) {
        when (it) {
            Screens.ContentScreen -> navController.navigateToContent()
            Screens.DetailsScreen -> navController.navigateToDetails()
            Screens.HomeScreen -> navController.navigateToHome()
            Screens.SettingScreen -> navController.navigateToSetting()
            Screens.SheikhsScreen -> navController.navigateToSheikhs()
            Screens.SplashScreen -> navController.navigateToSplash()
        }
    }
}


@Composable
fun HomeContent(homeState: HomeState = HomeState(), onClick: (route: Screens) -> Unit = {}) {
    Column {
        Title(
            modifier = Modifier.padding(start = MaterialTheme.dimension.spacing16),
            text = stringResource(R.string.popular)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing16),
            verticalItemSpacing = MaterialTheme.dimension.spacing16,
            contentPadding = PaddingValues(MaterialTheme.dimension.spacing16)
        ) {
            items(homeState.categories) { item ->
                HomeCardItem(
                    height = item.height,
                    color = item.color,
                    image = item.image,
                    title = item.title
                ) {
                    onClick(Screens.ContentScreen)
                }
            }
        }
    }
}


@ThemePreviews
@Composable
fun HomeScreenPreview() {
    SonnaAppTheme {
        HomeContent()
    }
}