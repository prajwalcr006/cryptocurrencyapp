package com.example.cryptocurrencyapp.presentation.coin_list

import com.example.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val loading: Boolean = true,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
