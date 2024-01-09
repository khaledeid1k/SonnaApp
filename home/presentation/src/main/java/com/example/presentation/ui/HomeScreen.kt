package com.example.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.Spacing16
import com.example.designsystem.R
import com.example.designsystem.theme.SonnaAppTheme
import com.example.presentation.ui.composables.HomeCardItem
import com.example.presentation.ui.composables.Title


@Composable
fun HomeScreen() {
}



@Composable
fun HomeContent(homeState: HomeState) {
    Column {
        Title(
            modifier = Modifier.padding(start = Spacing16),
            text = stringResource(R.string.popular)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.spacedBy(Spacing16),
            verticalItemSpacing = Spacing16,
            contentPadding = PaddingValues(Spacing16)
        ) {
            items(homeState.categories) { item ->
                HomeCardItem(
                    height = item.height,
                    color = item.color,
                    image = item.image,
                    title = R.string.popular
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    SonnaAppTheme {
       // HomeContent()
    }
}