package com.example.cryptocurrencyapp.domain.model

import kotlinx.serialization.SerialName

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Long,
    val isActive: Boolean,
)
