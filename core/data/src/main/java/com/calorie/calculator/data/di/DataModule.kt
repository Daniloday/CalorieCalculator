package com.calorie.calculator.data.di

import com.calorie.calculator.data.repository.TestRepo
import com.calorie.calculator.data.repository_impl.TestRepoImpl
import org.koin.dsl.module

val dataModule = module {
    single<TestRepo> { TestRepoImpl(get()) }
}