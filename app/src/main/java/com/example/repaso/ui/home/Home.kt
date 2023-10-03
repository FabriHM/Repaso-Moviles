package com.example.repaso.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.repaso.ui.products.Search

@Composable
fun Home(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Search.route) {
    }
}

sealed class Routes(val route: String) {
    object Search: Routes("ProductSearch")
}