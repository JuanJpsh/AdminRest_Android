package com.example.adminrest.ui

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.compose.ui.focus.FocusState
import androidx.lifecycle.ViewModel
import com.example.adminrest.R
import com.example.adminrest.data.RegisterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class Field {
    Username,
    Lastname,
    Email,
    Password,
    RepeatPassword,
}

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun updateUsername(updateUsername: String) {
        val usernameError = getFieldError(updateUsername, Field.Username)

        _uiState.update { currentState ->
            currentState.copy(
                username = updateUsername,
                usernameError = usernameError
            )
        }

        if (usernameError != "") _uiState.update { currentState ->
            currentState.copy(usernameHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(usernameHasError = false)
        }
    }

    fun updateLastname(updateLastname: String) {
        val lastnameError = getFieldError(updateLastname, Field.Lastname)

        _uiState.update { currentState ->
            currentState.copy(
                lastname = updateLastname,
                lastnameError = lastnameError
            )
        }

        if (lastnameError != "") _uiState.update { currentState ->
            currentState.copy(lastnameHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(lastnameHasError = false)
        }
    }

    fun updateEmail(updateEmail: String) {
        val emailError = getFieldError(updateEmail, Field.Email)

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
        val passwordError = getFieldError(updatePassword, Field.Password)

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

    fun updateRepeatPassword(updateRepeatPassword: String) {
        val repeatPasswordError = getFieldError(updateRepeatPassword, Field.RepeatPassword)

        _uiState.update { currentState ->
            currentState.copy(
                repeatPassword = updateRepeatPassword,
                repeatPasswordError = repeatPasswordError
            )
        }

        if (repeatPasswordError != "") _uiState.update { currentState ->
            currentState.copy(repeatPasswordHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(repeatPasswordHasError = false)
        }
    }

    fun focusEventUsernameField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.usernmaeFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(usernmaeFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.usernmaeFocusEventsCount == 1) {
            val usernameError = getFieldError(uiState.value.username, Field.Username)
            _uiState.update { currentState ->
                currentState.copy(
                    usernmaeFocusEventsCount = 2,
                    showUsernameError = true,
                    usernameError = usernameError,
                    usernameHasError = (usernameError != "")
                )
            }
        }
    }

    fun focusEventLastnameField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.lastnameFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(lastnameFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.lastnameFocusEventsCount == 1) {
            val lastnameError = getFieldError(uiState.value.lastname, Field.Lastname)
            _uiState.update { currentState ->
                currentState.copy(
                    lastnameFocusEventsCount = 2,
                    showLastnameError = true,
                    lastnameError = lastnameError,
                    lastnameHasError = (lastnameError != "")
                )
            }
        }
    }

    fun focusEventEmailField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.emailFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(emailFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.emailFocusEventsCount == 1) {
            val emailError = getFieldError(uiState.value.email, Field.Email)
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
            val passwordError = getFieldError(uiState.value.password, Field.Password)
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

    fun focusEventRepeatPasswordField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.repeatPasswordFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(repeatPasswordFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.repeatPasswordFocusEventsCount == 1) {
            val repeatPasswordError = getFieldError(uiState.value.repeatPassword, Field.RepeatPassword)
            _uiState.update { currentState ->
                currentState.copy(
                    repeatPasswordFocusEventsCount = 2,
                    showRepeatPasswordError = true,
                    repeatPasswordError = repeatPasswordError,
                    repeatPasswordHasError = (repeatPasswordError != "")
                )
            }
        }
    }

    fun checkData(): Boolean {
        val usernameError = getFieldError(uiState.value.username, Field.Username)
        val lastnameError = getFieldError(uiState.value.lastname, Field.Lastname)
        val emailError = getFieldError(uiState.value.email, Field.Email)
        val passwordError = getFieldError(uiState.value.password, Field.Password)
        val repeatPasswordError = getFieldError(uiState.value.repeatPassword, Field.RepeatPassword)

        if (
            usernameError == "" &&
            lastnameError == "" &&
            emailError == "" &&
            passwordError == "" &&
            repeatPasswordError == ""
        )
        {
            return true
        } else {
            val usernameHasError = (usernameError != "")
            val lastnameHasError = (lastnameError != "")
            val emailHasError = (emailError != "")
            val passwordHasError = (passwordError != "")
            val repeatPasswordHasError = (repeatPasswordError != "")

            _uiState.update { currentState ->
                currentState.copy(
                    showUsernameError = usernameHasError,
                    usernameHasError = usernameHasError,
                    usernameError = usernameError,

                    showLastnameError = lastnameHasError,
                    lastnameHasError = lastnameHasError,
                    lastnameError = lastnameError,

                    showEmailError = emailHasError,
                    emailHasError = emailHasError,
                    emailError = emailError,

                    showPasswordError = passwordHasError,
                    passwordHasError = passwordHasError,
                    passwordError = passwordError,

                    showRepeatPasswordError = repeatPasswordHasError,
                    repeatPasswordHasError = repeatPasswordHasError,
                    repeatPasswordError = repeatPasswordError,
                )
            }
        }
        return false
    }

    private fun getFieldError(value: String, field: Field): String {
        if (value.isEmpty()) return "Este campo es obligatorio."
        when (field) {
            Field.Username -> {
                val pattern = Regex(".{3,}")
                if (!pattern.matches(value)) return "El nombre debe contener al menos 3 caracteres."
            }
            Field.Lastname -> {
                val pattern = Regex(".{3,}")
                if (!pattern.matches(value)) return "El apellido debe contener al menos 3 caracteres."
            }
            Field.Email -> {
                val pattern = Patterns.EMAIL_ADDRESS
                if (!pattern.matcher(value).matches()) return "Correo electrónico invalido."
            }
            Field.Password -> {
                val pattern = Regex(".{8,}")
                if (!pattern.matches(value)) return "La contraseña debe contener al menos 8 caracteres."
            }
            Field.RepeatPassword -> {
                if (uiState.value.password != value) return "La contraseña no coincide."
            }
        }
        return ""
    }
}