package com.example.effectivemobiletest.presentation.main

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val route: String,
    val title: String,
    @DrawableRes val iconRes: Int,
)
