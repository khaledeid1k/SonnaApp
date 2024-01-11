package com.sonna.presentation.home

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sonna.common.R

data class HomeState(
    val categories: List<Category> = listOf(
        Category(height = 163.dp, image = R.drawable.quarn,
            color = Color(0x4D2BFF00), title = R.string.quran),
        Category(height = 191.dp, image = R.drawable.hadith,
            color = Color(0xB3FF643D), title = R.string.hadith),
        Category(height = 191.dp, image = R.drawable.shek,
            color = Color(0xB3FFB92C), title = R.string.listening),
        Category(height = 163.dp, image = R.drawable.zekr,
            color = Color(0xB34865FF), title = R.string.azkar),
    ) ,

)


data class Category(
    val height: Dp,
    val image: Int,
    val color: Color,
    @StringRes val title :Int
)