package com.calorie.calculator.network.di

import com.calorie.calculator.network.NetworkDataSource
import com.calorie.calculator.network.retrofit.RetrofitNetworkDataSource
import org.koin.dsl.module



val networkModule = module {
    single<NetworkDataSource> { RetrofitNetworkDataSource() }
}


