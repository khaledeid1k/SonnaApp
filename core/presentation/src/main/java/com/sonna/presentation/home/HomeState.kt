package com.sonna.presentation.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.R

data class HomeState(
    val categories: List<Category> = listOf(
        Category(height = 163.dp, image = R.drawable.quarn, color = Color(0x4D2BFF00)),
        Category(height = 191.dp, image = R.drawable.hadith, color = Color(0xB3FF643D)),
        Category(height = 191.dp, image = R.drawable.shek, color = Color(0xB3FFB92C)),
        Category(height = 163.dp, image = R.drawable.zekr, color = Color(0xB34865FF)),
    ) ,

)


data class Category(
    val height: Dp, val image: Int, val color: Color
)