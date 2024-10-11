package com.valito.rickmortyapp.di

import com.valito.rickmortyapp.ui.home.tabs.characters.CharacterViewModel
import com.valito.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharacterViewModel)
}