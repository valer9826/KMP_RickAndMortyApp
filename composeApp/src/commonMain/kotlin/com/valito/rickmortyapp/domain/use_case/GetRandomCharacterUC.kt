package com.valito.rickmortyapp.domain.use_case

import com.valito.rickmortyapp.domain.Repository
import com.valito.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacterUC(private val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {
        val randomCharacterId = (1..826).random()
        return repository.getSingleCharacter(id = randomCharacterId.toString())
    }

}