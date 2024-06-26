package com.sonna.screens.home

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sonna.common.R
import com.sonna.common.routes.Screens
import com.sonna.common.theme.darkBlueWithRedTint
import com.sonna.common.theme.darkGreenishOrange
import com.sonna.common.theme.greenishYellow
import com.sonna.common.theme.semiTransparentBlue


data class HomeState(
    val categories: List<Category> = listOf(
        Category(height = 163.dp, image = R.drawable.quarn,
            color = semiTransparentBlue, title = R.string.quran, route = Screens.ContentScreen),
        Category(height = 191.dp, image = R.drawable.hadith,
            color = greenishYellow, title = R.string.hadith, route = Screens.ContentScreen),
        Category(height = 191.dp, image = R.drawable.shek,
            color = darkGreenishOrange, title = R.string.sheikhs, route = Screens.SheikhsScreen),
        Category(height = 163.dp, image = R.drawable.zekr,
            color = darkBlueWithRedTint, title = R.string.azkar, route = Screens.ContentScreen),
    ) ,

)


data class Category(
    val height: Dp,
    val image: Int,
    val color: Color,
    @StringRes val title :Int,
    val route:Screens
)