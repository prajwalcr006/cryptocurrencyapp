package com.example.cryptocurrencyapp

import android.app.Application
import com.example.cryptocurrencyapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoinApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CoinApplication)
            modules(appModule)
        }
    }

}