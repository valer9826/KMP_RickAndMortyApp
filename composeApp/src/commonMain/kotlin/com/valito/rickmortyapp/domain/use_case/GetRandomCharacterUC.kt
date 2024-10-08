package com.valito.rickmortyapp.domain.use_case

import com.valito.rickmortyapp.domain.Repository

class GetRandomCharacterUC(private val repository: Repository) {

    suspend operator fun invoke() {
        val randomCharacterId = (1..826).random()
        repository.getSingleCharacter(id = randomCharacterId.toString() )
    }

}