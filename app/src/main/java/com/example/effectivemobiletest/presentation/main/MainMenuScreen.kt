package com.example.effectivemobiletest.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletest.R
import com.example.effectivemobiletest.presentation.navigation.AppDestinations

@Composable
fun MainMenuScreen() {
    val navController = rememberNavController()

    val items =
        listOf(
            BottomNavItem(
                route = AppDestinations.Home.route,
                title = "Главная",
                iconRes = R.drawable.home_icon,
            ),
            BottomNavItem(
                route = AppDestinations.Favorites.route,
                title = "Избранное",
                iconRes = R.drawable.favorite_icon,
            ),
            BottomNavItem(
                route = AppDestinations.Profile.route,
                title = "Аккаунт",
                iconRes = R.drawable.account_icon,
            ),
        )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
            ) {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.iconRes),
                                contentDescription = item.title,
                            )
                        },
                        label = {
                            Text(text = item.title)
                        },
                        colors =
                            NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.secondary,
                                selectedTextColor = MaterialTheme.colorScheme.secondary,
                                unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                                indicatorColor = MaterialTheme.colorScheme.primary,
                            ),
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestinations.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(AppDestinations.Home.route) {
                HomeTabScreen()
            }
            composable(AppDestinations.Favorites.route) {
                FavoritesTabScreen()
            }
            composable(AppDestinations.Profile.route) {
                ProfileTabScreen()
            }
        }
    }
}

@Composable
fun ProfileTabScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Аккаунт",
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
fun FavoritesTabScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Избранное",
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
fun HomeTabScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Главная",
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}
