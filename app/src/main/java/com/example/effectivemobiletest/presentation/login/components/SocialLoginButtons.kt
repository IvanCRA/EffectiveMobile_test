package com.example.effectivemobiletest.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SocialLoginButtons() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(
            modifier = Modifier.weight(1f),
            onClick = {}
        ) {
            Text("VK")
        }

        Button(
            modifier = Modifier.weight(1f),
            onClick = {}
        ) {
            Text("OK")
        }

    }

}
