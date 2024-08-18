package com.calorie.calculator.presentation.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class Shapes(
    val rectangle: Shape,
)

val shapes = Shapes(
    rectangle = RoundedCornerShape(0.dp),
)

val LocalShapes = staticCompositionLocalOf<Shapes> {
    error("No shapes provided")
}