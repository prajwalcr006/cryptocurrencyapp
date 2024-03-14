package com.example.cryptocurrencyapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    @SerialName("link")
    val link: String,
    @SerialName("thumbnail")
    val thumbnail: String
)