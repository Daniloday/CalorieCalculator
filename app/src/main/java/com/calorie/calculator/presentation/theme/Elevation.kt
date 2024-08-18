package com.calorie.calculator.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Elevations (
    val button: Dp,
)

val elevations = Elevations(
    button = 10.dp,
)

val LocalElevations = staticCompositionLocalOf<Elevations> {
    error("No elevations provided")
}