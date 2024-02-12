package com.sonna.screens.sheikhs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sonna.common.R
import com.sonna.common.composables.BackHeader
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.sheikhs.composables.SheikhsList

@Composable
fun SheikhsScreen(
    navController: NavController,
) {
    SheikhsContent(SheikhsState())
}

@Composable
fun SheikhsContent(sheikhsState: SheikhsState = SheikhsState()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        BackHeader(modifier = Modifier
            .padding(
                horizontal = MaterialTheme.dimension.spacing16,
                vertical = MaterialTheme.dimension.spacing16
            ),
            title = R.string.sheikhs, backToHome = {})

        SheikhsList(sheikhsState.sheikhs)
    }

}

@ThemePreviews
@Composable
fun SheikhsPreview() {
    SonnaAppTheme {
        SheikhsContent()
    }
}