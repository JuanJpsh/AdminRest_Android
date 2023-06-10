package com.example.adminrest.ui

import android.util.Patterns
import androidx.compose.ui.focus.FocusState
import androidx.lifecycle.ViewModel
import com.example.adminrest.data.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun updateEmail(updateEmail: String) {
        val emailError = getEmailError(updateEmail)

        _uiState.update { currentState ->
            currentState.copy(
                email = updateEmail,
                emailError = emailError
            )
        }

        if (emailError != "") _uiState.update { currentState ->
            currentState.copy(emailHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(emailHasError = false)
        }
    }

    fun updatePassword(updatePassword: String) {
        val passwordError = getPasswordError(updatePassword)

        _uiState.update { currentState ->
            currentState.copy(
                password = updatePassword,
                passwordError = passwordError
            )
        }

        if (passwordError != "") _uiState.update { currentState ->
            currentState.copy(passwordHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(passwordHasError = false)
        }
    }

    fun focusEventEmailField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.emailFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(emailFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.emailFocusEventsCount == 1) {
            val emailError = getEmailError(uiState.value.email)
            _uiState.update { currentState ->
                currentState.copy(
                    emailFocusEventsCount = 2,
                    showEmailError = true,
                    emailError = emailError,
                    emailHasError = (emailError != "")
                )
            }
        }
    }

    fun focusEventPasswordField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.passwordFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(passwordFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.passwordFocusEventsCount == 1) {
            val passwordError = getPasswordError(uiState.value.password)
            _uiState.update { currentState ->
                currentState.copy(
                    passwordFocusEventsCount = 2,
                    showPasswordError = true,
                    passwordError = passwordError,
                    passwordHasError = (passwordError != "")
                )
            }
        }
    }
    fun checkCredentials(): Boolean {
        val emailError = getEmailError(uiState.value.email)
        val passwordError = getPasswordError(uiState.value.password)

        if (emailError == "" && passwordError == ""){
            return true
        } else if (!uiState.value.showEmailError || !uiState.value.showPasswordError) {
            val emailHasError = (emailError != "")
            val passwordHasError = (passwordError != "")

            _uiState.update { currentState ->
                currentState.copy(
                    showEmailError = emailHasError,
                    emailHasError = emailHasError,
                    emailError = emailError,
                    showPasswordError = passwordHasError,
                    passwordHasError = passwordHasError,
                    passwordError = passwordError
                )
            }
        }
        return false
    }
    private fun getEmailError(email: String): String {
        if (email.isEmpty()) return "Este campo es obligatorio."
        val pattern = Patterns.EMAIL_ADDRESS
        if (!pattern.matcher(email).matches()) return "Correo electrónico invalido."
        return ""
    }

    private fun getPasswordError(password: String): String {
        if (password.isEmpty()) return "Este campo es obligatorio."
        val pattern = Regex(".{8,}")
        if (!pattern.matches(password)) return "Contraseña invalida."
        return ""
    }
}