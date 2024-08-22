package com.calorie.calculator.ui_kit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val openSans = FontFamily()

@Immutable
data class Typography(
    val large: TextStyle,
)

val typography = Typography(

    large = TextStyle(
        fontFamily = openSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 16.sp
    )
)

val LocalTypography = staticCompositionLocalOf<Typography> {
    error("No typography provided")
}