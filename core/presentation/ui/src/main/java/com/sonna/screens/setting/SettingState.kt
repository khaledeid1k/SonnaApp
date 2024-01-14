package com.sonna.screens.setting

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sonna.common.R

data class SettingState(
    val settingComponents: List<SettingComponent> = listOf(
        SettingComponent(iconOfItem = R.drawable.quarn, nameOfItem = R.string.quran),
        SettingComponent(iconOfItem = R.drawable.hadith, nameOfItem = R.string.hadith),
        SettingComponent(iconOfItem = R.drawable.zekr, nameOfItem = R.string.hadith),
        SettingComponent(iconOfItem = R.drawable.general_setting, nameOfItem = R.string.general),

        )
)

data class SettingComponent(
    @DrawableRes val iconOfItem: Int,
    @StringRes val nameOfItem: Int,
    @DrawableRes val goToDetails: Int = R.drawable.got_to,
)