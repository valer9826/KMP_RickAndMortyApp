package com.valito.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valito.rickmortyapp.domain.Repository
import com.valito.rickmortyapp.domain.use_case.GetRandomCharacterUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(
    val getRandomCharacterUC: GetRandomCharacterUC,
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRandomCharacterUC()
            }
            _state.update {
                it.copy(character = result)
            }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _state.update {state ->
            state.copy(
                characters = repository.getAllCharacters()
            )
        }
    }


}