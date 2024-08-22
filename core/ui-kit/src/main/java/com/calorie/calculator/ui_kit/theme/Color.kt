package com.calorie.calculator.ui_kit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme (
    val primary: Color,
)


val lightColorPalette = ColorScheme(
    primary = Color(0xFFFFB81D),
)


val LocalColorScheme = staticCompositionLocalOf<ColorScheme> {
    error("No colors provided")
}