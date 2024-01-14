package com.sonna.screens.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sonna.screens.setting.composables.SettingsFeatures
import com.sonna.screens.setting.composables.HeaderOfSetting


@Composable
fun SettingScreen() {
    SettingContent(SettingState())
}
@Composable
fun SettingContent(settingState:SettingState) {
    Column(modifier = Modifier
        .fillMaxSize()) {
        HeaderOfSetting(backToHome = {})
        SettingsFeatures(settingState.settingComponents, moveToDetails = {})
    }
}

@Preview
@Composable
fun SettingPreview() {
    SettingContent(SettingState())
}