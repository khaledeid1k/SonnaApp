package com.sonna.common.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sonna.common.R


val montserrat = FontFamily(
    Font(R.font.montserrat_bold))

val amiri = FontFamily(
    Font(R.font.amiri_egular),
    Font(R.font.amiri_bold))

val Typography = Typography(
    headlineSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    ),
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    ),
    bodyMedium = TextStyle(
        fontSize = 30.sp,
        fontFamily = amiri,
        fontWeight = FontWeight.Bold,
        lineHeight = 60.sp,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    ),
    bodySmall = TextStyle(
        fontSize = 22.sp,
        fontFamily = amiri,
        fontWeight = FontWeight.Normal,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    )  ,

    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontFamily = montserrat,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        ),



    ) ,
    displayLarge = TextStyle(
        fontFamily = montserrat,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 60.sp,
    )

)