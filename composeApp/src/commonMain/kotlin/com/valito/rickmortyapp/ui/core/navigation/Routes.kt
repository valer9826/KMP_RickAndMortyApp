package com.valito.rickmortyapp.ui.core.navigation

sealed class Routes(val route: String) {

    data object Home : Routes(route = "home")


    //BottomNavBar
    data object Episodes: Routes(route = "episodes")
    data object Characters: Routes(route = "characters")

}