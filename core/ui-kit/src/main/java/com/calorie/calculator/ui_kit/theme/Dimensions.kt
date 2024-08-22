package com.calorie.calculator.ui_kit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimensions(
    val bodyPaddingHorizontal: Dp,
)

val dimensions = Dimensions(
    bodyPaddingHorizontal = 16.dp,
)

val LocalDimensions = staticCompositionLocalOf<Dimensions> {
    error("No dimensions provided")
}