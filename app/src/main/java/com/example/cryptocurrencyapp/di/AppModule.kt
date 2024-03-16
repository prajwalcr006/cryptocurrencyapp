package com.example.cryptocurrencyapp.di

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp.common.constants
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.respository.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
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

    factory {
        GetCoinsUseCase(get())
    }

    viewModel {
        CoinListViewModel(get())
    }
}