package com.sermage.surfteam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sermage.surfteam.ui.screens.MainScreen
import com.sermage.surfteam.ui.screens.SplashScreen

const val SPLASH_SCREEN_ROUTE = "splash_screen"
const val MAIN_SCREEN_ROUTE = "main_screen"
const val SEARCH_SCREEN_ROUTE = "search_screen"

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH_SCREEN_ROUTE,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(SPLASH_SCREEN_ROUTE) {
            SplashScreen(navController)
        }
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen()
        }
    }
}