package com.valito.rickmortyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.PagingSource
import app.cash.paging.PagingConfig
import com.valito.rickmortyapp.data.remote.ApiService
import com.valito.rickmortyapp.data.remote.paging.CharacterPagingSource
import com.valito.rickmortyapp.data.repository.mapper.toCharacterModel
import com.valito.rickmortyapp.domain.Repository
import com.valito.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val characterPagingSource: CharacterPagingSource
) : Repository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id = id).toCharacterModel()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { characterPagingSource }
        ).flow
    }
}

