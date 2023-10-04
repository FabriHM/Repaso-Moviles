package com.example.repaso.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repaso.ui.home.Home
import com.example.repaso.ui.products.Search

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.Home.route) {
        composable(route = AppScreen.Home.route) {
            Home(navController)
        }
        composable(route = AppScreen.Search.route) {
            Search()
        }
    }
}