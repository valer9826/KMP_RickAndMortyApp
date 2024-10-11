package com.valito.rickmortyapp.data.remote.response

import com.valito.rickmortyapp.domain.model.CharacterModel

data class CharacterWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

