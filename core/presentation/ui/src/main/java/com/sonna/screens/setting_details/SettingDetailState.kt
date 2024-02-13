package com.sonna.screens.setting_details

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sonna.common.R

data class SettingDetailState(
    @DrawableRes val iconOfItem: Int= R.drawable.quarn,
    @StringRes val nameOfItem: Int= R.string.quran,
    val valueOfFeature: String="Default Value",
    val featureEnabled: Boolean=false,
)