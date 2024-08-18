package com.calorie.calculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.calorie.calculator.presentation.navigation.NavGraph
import com.calorie.calculator.presentation.theme.CalorieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTheme {
                NavGraph()
            }
        }
    }
}