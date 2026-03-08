package com.example.effectivemobiletest.presentation.navigation

sealed class AppDestinations(val route: String) {
    data object Login : AppDestinations("login")

    data object Main : AppDestinations("main")

    data object Home : AppDestinations("home")

    data object Favorites : AppDestinations("favorites")

    data object Profile : AppDestinations("profile")
}
