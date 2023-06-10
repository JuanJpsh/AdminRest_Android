package com.example.adminrest.ui

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.adminrest.data.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private fun getEmailError(email: String): String {
        if (email.isEmpty()) return "Este campo es obligatorio"
        val pattern = Patterns.EMAIL_ADDRESS
        if (!pattern.matcher(email).matches()) return "Correo electrónico invalido"
        return ""
    }

    private fun getPasswordError(password: String): String {
        if (password.isEmpty()) return "Este campo es obligatorio"
        val pattern = Regex(".{8,}")
        if (!pattern.matches(password)) return "Contraseña invalida"
        return ""
    }
}