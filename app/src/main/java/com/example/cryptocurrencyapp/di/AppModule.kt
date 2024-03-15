package com.example.cryptocurrencyapp.di

import com.example.cryptocurrencyapp.common.constants
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.respository.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    single<CoinRepository> {
        CoinRepositoryImpl(get())
    }
}