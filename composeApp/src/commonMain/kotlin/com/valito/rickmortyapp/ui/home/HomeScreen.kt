package com.valito.rickmortyapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.valito.rickmortyapp.ui.core.navigation.bottomNavigation.BottomNavBarItem
import com.valito.rickmortyapp.ui.core.navigation.bottomNavigation.BottomNavBarItem.*
import com.valito.rickmortyapp.ui.core.navigation.bottomNavigation.NavigationBottomWrapper

@Composable
fun HomeScreen() {
    val listItems = listOf(Episodes(), Characters())
    val bottomNavController = rememberNavController()

    Scaffold(bottomBar = {
        BottomBarNavigation(
            listItems = listItems,
            bottomNavController = bottomNavController
        )
    }) {
        Box {
            NavigationBottomWrapper(navController = bottomNavController)
        }
    }
}

@Composable
fun BottomBarNavigation(listItems: List<BottomNavBarItem>, bottomNavController: NavHostController) {

    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {
        listItems.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                onClick = {
                    bottomNavController.navigate(route = item.route) {
                        bottomNavController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                alwaysShowLabel = false
            )
        }
    }
}