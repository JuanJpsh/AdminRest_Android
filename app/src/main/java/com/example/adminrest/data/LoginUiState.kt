package com.example.adminrest.data

data class LoginUiState (
    val email: String = "",
    val password: String = "",
    val showEmailError: Boolean = false,
    val showPasswordError: Boolean = false,
    val emailHasError: Boolean = false,
    val passwordHasError: Boolean = false,
    val emailFocusEventsCount: Int = 0,
    val passwordFocusEventsCount: Int = 0,
    val emailError: String = "",
    val passwordError: String = "",
)