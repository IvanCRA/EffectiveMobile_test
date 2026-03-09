package com.example.effectivemobiletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.effectivemobiletest.presentation.home.HomeScreen
import com.example.effectivemobiletest.presentation.navigation.AppNavHost
import com.example.effectivemobiletest.ui.theme.EffectiveMobileTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileTestTheme {
                HomeScreen()
            }
        }
    }
}
