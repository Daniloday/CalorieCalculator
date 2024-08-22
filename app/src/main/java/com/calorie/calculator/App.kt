package com.calorie.calculator

import android.app.Application
import com.calorie.calculator.data.di.dataModule
import com.calorie.calculator.domain.di.domainModule
import com.calorie.calculator.network.di.networkModule
import com.calorie.calculator.test.testModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                dataModule,
                domainModule,
                testModule
            )
        }
    }
}

