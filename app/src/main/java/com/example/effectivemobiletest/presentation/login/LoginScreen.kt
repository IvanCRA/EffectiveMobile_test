package com.example.effectivemobiletest.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.effectivemobiletest.presentation.login.components.EmailField
import com.example.effectivemobiletest.presentation.login.components.LoginButton
import com.example.effectivemobiletest.presentation.login.components.LoginHeader
import com.example.effectivemobiletest.presentation.login.components.PasswordField
import com.example.effectivemobiletest.presentation.login.components.SocialLoginButtons

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        LoginHeader()

        Spacer(modifier = Modifier.height(32.dp))

        EmailField(
            value = state.email,
            onValueChange = viewModel::onEmailChanged
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordField(
            value = state.password,
            onValueChange = viewModel::onPasswordChanged
        )

        Spacer(modifier = Modifier.height(25.dp))

        LoginButton(
            onClick = viewModel::login
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(32.dp))

        SocialLoginButtons()

    }
}

