package com.example.effectivemobiletest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletest.presentation.login.LoginScreen
import com.example.effectivemobiletest.presentation.main.MainMenuScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.Login.route,
        modifier = modifier,
    ) {
        composable(AppDestinations.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppDestinations.Main.route) {
                        popUpTo(AppDestinations.Login.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }

        composable(AppDestinations.Main.route) {
            MainMenuScreen()
        }
    }
}
