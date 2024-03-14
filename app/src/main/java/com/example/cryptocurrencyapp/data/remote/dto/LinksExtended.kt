package com.example.cryptocurrencyapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    @SerialName("stats")
    val stats: Stats,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)