package com.calorie.calculator.ui_kit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun CalorieTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides lightColorPalette,
//        LocalTypography provides typography,
        LocalDimensions provides dimensions,
        LocalElevations provides elevations,
        LocalShapes provides shapes,
        content = content,
    )
}

object AppTheme {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current


    val types: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimens: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val elevations: Elevations
        @Composable
        @ReadOnlyComposable
        get() = LocalElevations.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}