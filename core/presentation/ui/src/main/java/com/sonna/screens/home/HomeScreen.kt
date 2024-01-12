package com.sonna.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sonna.common.R
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.home.composables.HomeCardItem
import com.sonna.screens.home.composables.Title
import com.sonna.viewmodel.home.HomeViewModel


@Composable
fun HomeScreen(homeViewModel : HomeViewModel = hiltViewModel()) {

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(homeState: HomeState) {
    Column {
        Title(
            modifier = Modifier.padding(start = MaterialTheme.dimension.spacing16),
            text = stringResource(R.string.popular)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.spacing16),
            verticalItemSpacing =MaterialTheme. dimension.spacing16,
            contentPadding = PaddingValues(MaterialTheme.dimension.spacing16)
        ) {
            items(homeState.categories) { item ->
                HomeCardItem(
                    height = item.height,
                    color = item.color,
                    image = item.image,
                    title = item.title
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    SonnaAppTheme {
        HomeContent(HomeState())
    }
}