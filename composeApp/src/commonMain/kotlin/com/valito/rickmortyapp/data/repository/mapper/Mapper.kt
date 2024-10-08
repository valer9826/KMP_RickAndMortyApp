package com.valito.rickmortyapp.data.repository.mapper

import com.valito.rickmortyapp.data.remote.response.CharacterResponse
import com.valito.rickmortyapp.domain.model.CharacterModel

fun CharacterResponse.toCharacterModel(): CharacterModel {
    return CharacterModel(
        id = this.id,
        isAlive = this.status.contains("Alive"),
        image = this.image
    )
}