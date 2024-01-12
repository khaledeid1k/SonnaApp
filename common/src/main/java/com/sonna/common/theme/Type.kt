package com.sonna.common.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonna.common.R


val montserrat = FontFamily(
    Font(R.font.montserrat_bold))

val Typography = Typography(
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold
    ),

)