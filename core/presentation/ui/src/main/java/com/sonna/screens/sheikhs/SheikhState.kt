package com.sonna.screens.sheikhs

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sonna.common.R

data class SheikhsState(
    val sheikhs: List<SheikhState> = listOf(
        SheikhState(
            photoSheik = R.drawable.shek_gamal,
            nameOfSheik = R.string.gamal_mohammed,
            hintAboutSheik = R.string.azhar_preacher
        )
    )
)

data class SheikhState(
    @DrawableRes val photoSheik: Int,
    @StringRes val nameOfSheik: Int,
    @StringRes val hintAboutSheik: Int
)
