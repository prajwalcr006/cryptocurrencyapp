package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailState(
    val loading: Boolean = true,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)
