package com.example.cryptocurrencyapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamMember(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("position")
    val position: String
)