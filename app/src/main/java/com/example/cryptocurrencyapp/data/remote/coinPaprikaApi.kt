package com.example.cryptocurrencyapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface coinPaprikaApi {

    @GET("https://api.coinpaprika.com/v1/coins")
    suspend fun getCoins() {

    }

    @GET("https://api.coinpaprika.com/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) {

    }
}