package com.valito.rickmortyapp.domain

import androidx.paging.PagingData
import com.valito.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}