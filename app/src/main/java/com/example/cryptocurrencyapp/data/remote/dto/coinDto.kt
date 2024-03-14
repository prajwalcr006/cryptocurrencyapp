package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.Coin
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class CoinDto (
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Long,

    @SerialName("is_new")
    val isNew: Boolean,

    @SerialName("is_active")
    val isActive: Boolean,

    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id=this.id,
        name=this.name,
        symbol=this.symbol,
        rank=this.rank,
        isActive=this.isActive
    )
}
