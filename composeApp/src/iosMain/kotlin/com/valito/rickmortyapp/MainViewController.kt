package com.valito.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import com.valito.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }