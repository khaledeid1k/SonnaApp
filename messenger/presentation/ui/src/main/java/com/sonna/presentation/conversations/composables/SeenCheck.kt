package com.sonna.presentation.conversations.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun SeenCheck(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "done_all",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12.083f, 29.25f)
                quadToRelative(-0.25f, 0f, -0.458f, -0.083f)
                quadToRelative(-0.208f, -0.084f, -0.417f, -0.292f)
                lineToRelative(-7.333f, -7.333f)
                quadToRelative(-0.375f, -0.375f, -0.375f, -0.959f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                quadToRelative(0.417f, -0.417f, 0.937f, -0.396f)
                quadToRelative(0.521f, 0.021f, 0.938f, 0.396f)
                lineToRelative(6.375f, 6.417f)
                lineTo(14f, 27.917f)
                lineToRelative(-0.958f, 0.916f)
                quadToRelative(-0.209f, 0.25f, -0.438f, 0.334f)
                quadToRelative(-0.229f, 0.083f, -0.521f, 0.083f)
                close()
                moveToRelative(7.5f, 0f)
                quadToRelative(-0.25f, 0f, -0.479f, -0.083f)
                quadToRelative(-0.229f, -0.084f, -0.437f, -0.292f)
                lineToRelative(-7.334f, -7.333f)
                quadToRelative(-0.375f, -0.375f, -0.375f, -0.959f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                quadToRelative(0.417f, -0.375f, 0.938f, -0.375f)
                quadToRelative(0.521f, 0f, 0.896f, 0.375f)
                lineToRelative(6.416f, 6.417f)
                lineToRelative(14.709f, -14.75f)
                quadToRelative(0.375f, -0.375f, 0.937f, -0.375f)
                quadToRelative(0.563f, 0f, 0.938f, 0.375f)
                quadToRelative(0.416f, 0.416f, 0.416f, 0.958f)
                reflectiveQuadToRelative(-0.416f, 0.917f)
                lineTo(20.5f, 28.875f)
                quadToRelative(-0.208f, 0.208f, -0.438f, 0.292f)
                quadToRelative(-0.229f, 0.083f, -0.479f, 0.083f)
                close()
                moveToRelative(0f, -6.917f)
                lineToRelative(-1.875f, -1.875f)
                lineToRelative(9.125f, -9.166f)
                quadToRelative(0.375f, -0.375f, 0.938f, -0.375f)
                quadToRelative(0.562f, 0f, 0.937f, 0.416f)
                quadToRelative(0.375f, 0.375f, 0.375f, 0.938f)
                quadToRelative(0f, 0.562f, -0.375f, 0.937f)
                close()
            }
        }.build()
    }
}