package com.sonna.screens.settingDetails.general

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
import com.sonna.screens.settingDetails.SettingDetailState
import com.sonna.screens.settingDetails.composables.ValueSettingDetails


@Composable
fun SettingDetailsHadithScreen() {
    SettingDetailsGeneralContent()
}
@Composable
fun SettingDetailsGeneralContent() {
    Column( modifier = Modifier
        .padding(MaterialTheme.dimension.spacing16)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        BackHeader(title = R.string.general_setting) {}
        SpacerVertical(MaterialTheme.dimension.spacing16)

        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.language,
                nameOfItem= R.string.language,
                valueOfFeature ="AL Fatha" ,
            ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.font_size,
                nameOfItem= R.string.font_size,
                valueOfFeature ="AL Fatha" ,
            ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.contact_us,
                nameOfItem= R.string.contact_us,
            ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.help_support,
                nameOfItem= R.string.help_support,
            ), itemClick = {},changeValueOfSetting={})



    }
}


@ThemePreviews
@Composable
fun SettingDetailsGeneralPreview() {
    SonnaAppTheme {
        SettingDetailsGeneralContent()
    }
}