package com.example.effectivemobiletest.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.effectivemobiletest.presentation.login.components.ActionLogin
import com.example.effectivemobiletest.presentation.login.components.EmailField
import com.example.effectivemobiletest.presentation.login.components.LoginButton
import com.example.effectivemobiletest.presentation.login.components.LoginHeader
import com.example.effectivemobiletest.presentation.login.components.PasswordField
import com.example.effectivemobiletest.presentation.login.components.SocialLoginButtons

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        LoginHeader()

        Spacer(modifier = Modifier.height(32.dp))

        EmailField(
            value = state.email,
            onValueChange = viewModel::onEmailChanged,
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordField(
            value = state.password,
            onValueChange = viewModel::onPasswordChanged,
        )

        Spacer(modifier = Modifier.height(25.dp))

        LoginButton(
            enabled = state.isLoginEnabled,
            onClick = onLoginSuccess,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ActionLogin(
                onRegisterClick = { },
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Забыл пароль",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.clickable { },
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(32.dp))

        SocialLoginButtons()
    }
}
