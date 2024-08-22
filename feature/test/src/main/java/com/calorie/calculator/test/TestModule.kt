package com.calorie.calculator.test

import com.calorie.calculator.test.navigation.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val testModule = module {
    viewModel { SecondViewModel(get()) }
}