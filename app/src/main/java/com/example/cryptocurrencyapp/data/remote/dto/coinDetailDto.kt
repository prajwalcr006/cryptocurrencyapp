package com.example.cryptocurrencyapp.data.remote.dto


import com.example.cryptocurrencyapp.domain.model.CoinDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class coinDetailDto(
    @SerialName("description")
    val description: String,
    @SerialName("development_status")
    val developmentStatus: String,
    @SerialName("first_data_at")
    val firstDataAt: String,
    @SerialName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerialName("hash_algorithm")
    val hashAlgorithm: String,
    @SerialName("id")
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    @SerialName("last_data_at")
    val lastDataAt: String,
    @SerialName("links")
    val links: Links,
    @SerialName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerialName("logo")
    val logo: String,
    @SerialName("message")
    val message: String,
    @SerialName("name")
    val name: String,
    @SerialName("open_source")
    val openSource: Boolean,
    @SerialName("org_structure")
    val orgStructure: String,
    @SerialName("proof_type")
    val proofType: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("started_at")
    val startedAt: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("tags")
    val tags: List<Tag>,
    @SerialName("team")
    val team: List<TeamMember>,
    @SerialName("type")
    val type: String,
    @SerialName("whitepaper")
    val whitepaper: Whitepaper
)

fun coinDetailDto.toCoinDetail(): CoinDetails {
    return CoinDetails(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}