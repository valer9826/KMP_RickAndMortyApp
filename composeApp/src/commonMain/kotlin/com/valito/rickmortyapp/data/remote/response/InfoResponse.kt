package com.valito.rickmortyapp.data.remote.response

data class InfoResponse(
    val pages: Int,
    val prev: String?,
    val next: String?,
)