package com.sonna.screens.setting

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
import com.sonna.screens.content.navigateToContent
import com.sonna.screens.setting.composables.SettingsFeatures


@Composable
fun SettingScreen(
    navController: NavController,
) {
    SettingContent(SettingState()) {
        navController.navigateToContent()
    }
}

@Composable
fun SettingContent(settingState: SettingState = SettingState(), onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackHeader(modifier = Modifier
            .padding(
                horizontal = MaterialTheme.dimension.spacing16,
                vertical = MaterialTheme.dimension.spacing16
            ),
            title = R.string.setting, backToHome = {})
        SettingsFeatures(settingState.settingComponents, moveToDetails = {
            onClick()
        })
    }
}

@ThemePreviews
@Composable
fun SettingPreview() {
    SonnaAppTheme {
        SettingContent()
    }
}