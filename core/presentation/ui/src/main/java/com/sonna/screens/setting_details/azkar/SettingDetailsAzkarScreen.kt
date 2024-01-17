package com.sonna.screens.setting_details.azkar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonna.common.R
import com.sonna.common.composables.BackHeader
import com.sonna.common.composables.SpacerVertical
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.setting_details.SettingDetailState
import com.sonna.screens.setting_details.composables.SwitchSettingDetails
import com.sonna.screens.setting_details.composables.ValueSettingDetails


@Composable
fun SettingDetailsAzkarScreen() {
    SettingDetailsAzkarContent()
}
@Composable
fun SettingDetailsAzkarContent() {
    Column( modifier = Modifier
        .padding(MaterialTheme.dimension.spacing16)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        BackHeader(title = R.string.azkar_setting) {}
        SpacerVertical(spaceSize=MaterialTheme.dimension.spacing16)

        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.morning_azkar,
                nameOfItem= R.string.morning_azkar,
                valueOfFeature ="AL Fatha" ,
            ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.night_azkar,
                nameOfItem= R.string.morning_azkar,
                valueOfFeature ="AL Fatha" ,
            ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.sleep_azkar,
                nameOfItem= R.string.sleeping_azkar,
                valueOfFeature ="AL Fatha" ,
            ), itemClick = {},changeValueOfSetting={})



        SwitchSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.notification,
            nameOfItem=R.string.notification,
            valueOfFeature ="AL Fatha" ,
        )) {}

    }
}


@ThemePreviews
@Composable
fun SettingDetailsAzkarPreview() {
    SonnaAppTheme {
        SettingDetailsAzkarContent()
    }
}