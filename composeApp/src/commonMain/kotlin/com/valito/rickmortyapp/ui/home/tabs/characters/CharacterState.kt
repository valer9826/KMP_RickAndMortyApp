package com.valito.rickmortyapp.ui.home.tabs.characters

import androidx.paging.PagingData
import com.valito.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharacterState(
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)
