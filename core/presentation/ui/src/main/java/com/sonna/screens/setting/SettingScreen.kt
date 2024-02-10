package com.sonna.screens.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sonna.common.R
import com.sonna.screens.setting.composables.SettingsFeatures
import com.sonna.common.composables.BackHeader
import com.sonna.common.theme.dimension


@Composable
fun SettingScreen(
    navController: NavController?=null,
) {
    SettingContent(SettingState())
}

@Composable
fun SettingContent(settingState: SettingState) {
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
        SettingsFeatures(settingState.settingComponents, moveToDetails = {})
    }
}

@Preview
@Composable
fun SettingPreview() {
    SettingContent(SettingState())
}