package com.example.adminrest.data

data class LoginUiState (
    val email: String = "",
    val password: String = "",
    val correctCredentials: Boolean = false
)