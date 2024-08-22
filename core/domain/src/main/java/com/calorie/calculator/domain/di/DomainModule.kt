package com.calorie.calculator.domain.di

import com.calorie.calculator.domain.TestUseCase
import org.koin.dsl.module

val domainModule = module {
    single { TestUseCase(get()) }
}