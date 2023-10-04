package com.example.repaso.ui.navigation

sealed class AppScreen(val route: String) {
    object Home: AppScreen("home")
    object Search: AppScreen("search")

}