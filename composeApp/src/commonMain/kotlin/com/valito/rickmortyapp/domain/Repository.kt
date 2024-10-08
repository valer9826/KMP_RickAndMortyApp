package com.valito.rickmortyapp.domain

import com.valito.rickmortyapp.domain.model.CharacterModel

interface Repository {

    suspend fun getSingleCharacter(id: String): CharacterModel
}