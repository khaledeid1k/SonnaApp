package com.sonna.screens.setting_details.hadith

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.sonna.screens.setting_details.hadith.composables.DialogOfHadithBooks


@Composable
fun SettingDetailsHadithScreen() {
    SettingDetailsHadithContent()
}


@Composable
fun SettingDetailsHadithContent() {

    val openDialogHadithBooks = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(MaterialTheme.dimension.spacing16)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BackHeader(title = R.string.hadith_setting) {}
        SpacerVertical(spaceSize = MaterialTheme.dimension.spacing16)

        ValueSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.hadith_book,
                nameOfItem = R.string.hadith_book,
                valueOfFeature = "AL Fatha",
            ), changeValueOfSetting = {
                openDialogHadithBooks.value = true
            })
        if (openDialogHadithBooks.value) {
            DialogOfHadithBooks(
                onDismissRequest = { openDialogHadithBooks.value = false },
                hadithDialogSettingState = HadithSettingState().hadithDialogSettingState
            )
        }




        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.time,
            nameOfItem = R.string.time_show_hadith,
            valueOfFeature = "AL Fatha",
        ), changeValueOfSetting = {})
        SwitchSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.open,
                nameOfItem = R.string.show_when_open_phone,
                valueOfFeature = "AL Fatha",
            )
        ) {}
        ValueSettingDetails(SettingDetailState(
            iconOfItem = R.drawable.download,
            nameOfItem = R.string.download_book_hadith,
            valueOfFeature = "AL Fatha",
        ), changeValueOfSetting = {})

        SwitchSettingDetails(
            SettingDetailState(
                iconOfItem = R.drawable.close,
                nameOfItem = R.string.prevent_show_hadith,
                valueOfFeature = "AL Fatha",
            )
        ) {}
    }
}

@ThemePreviews
@Composable
fun SettingDetailsHadithPreview() {
    SonnaAppTheme {
        SettingDetailsHadithContent()
    }
}
