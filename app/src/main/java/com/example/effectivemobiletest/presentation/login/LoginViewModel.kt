package com.example.effectivemobiletest.presentation.login

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletest.presentation.login.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun onEmailChanged(input: String) {
        val filteredEmail = input.filterNot { it.isCyrillic() }

        _state.update { current ->
            val updated = current.copy(email = filteredEmail)
            updated.copy(
                isEmailValid = isValidEmail(filteredEmail),
                isLoginEnabled =
                    canLogin(
                        email = filteredEmail,
                        password = updated.password,
                    ),
            )
        }
    }

    fun onPasswordChanged(input: String) {
        _state.update { current ->
            val updated = current.copy(password = input)
            updated.copy(
                isLoginEnabled =
                    canLogin(
                        email = updated.email,
                        password = input,
                    ),
            )
        }
    }

    private fun canLogin(email: String, password: String): Boolean {
        return email.isNotBlank() &&
            password.isNotBlank() &&
            isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return email.matches(emailRegex)
    }

    private fun Char.isCyrillic(): Boolean {
        return this in '\u0400'..'\u04FF' || this in '\u0500'..'\u052F'
    }
}
