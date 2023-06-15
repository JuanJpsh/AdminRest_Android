package com.example.adminrest.data

data class PaymentUiState (
    val usernameT: String = "",
    val lastnameT: String = "",
    val numberT: String = "",
    val dateT: String = "",
    val codeT: String = "",

    val showUsernameTError: Boolean = false,
    val showLastnameTError: Boolean = false,
    val showNumberError: Boolean = false,
    val showDateError: Boolean = false,
    val showCodeError: Boolean = false,

    val usernameTHasError: Boolean = false,
    val lastnameTHasError: Boolean = false,
    val numberHasError: Boolean = false,
    val dateHasError: Boolean = false,
    val codeHasError: Boolean = false,

    val usernameTFocusEventsCount: Int = 0,
    val lastnameTFocusEventsCount: Int = 0,
    val numberFocusEventsCount: Int = 0,
    val dateFocusEventsCount: Int = 0,
    val codeFocusEventsCount: Int = 0,

    val usernameTError: String = "",
    val lastnameTError: String = "",
    val numberError: String = "",
    val dateError: String = "",
    val codeError: String = "",
)