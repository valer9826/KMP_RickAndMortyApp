package com.valito.rickmortyapp.data.repository

import com.valito.rickmortyapp.data.remote.ApiService
import com.valito.rickmortyapp.data.repository.mapper.toCharacterModel
import com.valito.rickmortyapp.domain.Repository
import com.valito.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService) : Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id = id).toCharacterModel()
    }
}

