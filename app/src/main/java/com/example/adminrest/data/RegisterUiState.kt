package com.example.adminrest.data

data class RegisterUiState (
    val username: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",

    val showUsernameError: Boolean = false,
    val showLastnameError: Boolean = false,
    val showEmailError: Boolean = false,
    val showPasswordError: Boolean = false,
    val showRepeatPasswordError: Boolean = false,

    val usernameHasError: Boolean = false,
    val lastnameHasError: Boolean = false,
    val emailHasError: Boolean = false,
    val passwordHasError: Boolean = false,
    val repeatPasswordHasError: Boolean = false,

    val usernmaeFocusEventsCount: Int = 0,
    val lastnameFocusEventsCount: Int = 0,
    val emailFocusEventsCount: Int = 0,
    val passwordFocusEventsCount: Int = 0,
    val repeatPasswordFocusEventsCount: Int = 0,

    val usernameError: String = "",
    val lastnameError: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val repeatPasswordError: String = "",
)