package com.example.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.designsystem.R


val montserrat = FontFamily(
    Font(R.font.montserrat_bold))

val Typography = Typography(
    titleMedium = TextStyle(
        fontSize = TextSize20,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
    ),

)