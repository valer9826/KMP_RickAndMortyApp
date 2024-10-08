package com.valito.rickmortyapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id")
    val id: String,
    @SerialName("status")
    val status: String,
    val image: String,
)