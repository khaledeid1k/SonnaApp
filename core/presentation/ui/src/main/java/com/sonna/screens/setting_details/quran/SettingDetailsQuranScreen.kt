package com.sonna.screens.setting_details.quran

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
fun SettingDetailsQuranScreen() {
    SettingDetailsQuranContent()
}



@Composable
fun SettingDetailsQuranContent() {
    Column( modifier = Modifier
        .padding(MaterialTheme.dimension.spacing16)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        BackHeader(title = R.string.quran_setting) {}
        SpacerVertical(spaceSize=MaterialTheme.dimension.spacing16)

        ValueSettingDetails(
            SettingDetailState(
            iconOfItem = R.drawable.surah,
            nameOfItem=R.string.surah,
            valueOfFeature ="AL Fatha" ,
        ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.aya,
            nameOfItem=R.string.aya,
            valueOfFeature ="AL Fatha" ,
        ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.quran_reader,
            nameOfItem=R.string.reader,
            valueOfFeature ="AL Fatha" ,
        ), itemClick = {},changeValueOfSetting={})
        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.time,
            nameOfItem=R.string.time_show_aya,
            valueOfFeature ="AL Fatha" ,
        ), itemClick = {},changeValueOfSetting={})
        SwitchSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.open,
            nameOfItem=R.string.show_when_open_phone,
            valueOfFeature ="AL Fatha" ,
        )) {}

        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.download,
            nameOfItem=R.string.download_surah,
            valueOfFeature ="AL Fatha" ,
        ), itemClick = {},changeValueOfSetting={})

        SwitchSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.close,
            nameOfItem=R.string.prevent_show_quran,
            valueOfFeature ="AL Fatha" ,
        )) {}
    }
}


@ThemePreviews
@Composable
fun SettingDetailsQuranPreview() {
    SonnaAppTheme {
        SettingDetailsQuranContent()
    }
}

