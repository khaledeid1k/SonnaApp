package com.sonna.screens.settingDetails.quran

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sonna.common.R

data class SettingDetailsQuranState(
    val settingDetailsQuranItem: List<SettingDetailItem> = listOf(
        SettingDetailItem(),
        SettingDetailItem(),
        SettingDetailItem()
    )
)

data class SettingDetailItem(
    @DrawableRes val iconOfItem: Int= R.drawable.quarn,
    @StringRes val nameOfItem: Int=R.string.quran,
    val valueOfFeature: String="",
    val featureEnabled: Boolean=false,
)