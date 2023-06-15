package com.example.adminrest.ui

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.compose.ui.focus.FocusState
import androidx.lifecycle.ViewModel
import com.example.adminrest.R
import com.example.adminrest.data.PaymentUiState
import com.example.adminrest.data.RegisterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class FieldT {
    UsernameT,
    LastnameT,
    NumberT,
    DateT,
    CodeT,
}

class PaymentViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PaymentUiState())
    val uiState: StateFlow<PaymentUiState> = _uiState.asStateFlow()


    fun updateUsernameT(updateUsernameT: String) {
        val usernameTError = getFieldError(updateUsernameT, FieldT.UsernameT)

        _uiState.update { currentState ->
            currentState.copy(
                usernameT = updateUsernameT,
                usernameTError = usernameTError
            )
        }

        if (usernameTError != "") _uiState.update { currentState ->
            currentState.copy(usernameTHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(usernameTHasError = false)
        }
    }

    fun updateLastnameT(updateLastnameT: String) {
        val lastnameTError = getFieldError(updateLastnameT, FieldT.LastnameT)

        _uiState.update { currentState ->
            currentState.copy(
                lastnameT = updateLastnameT,
                lastnameTError = lastnameTError
            )
        }

        if (lastnameTError != "") _uiState.update { currentState ->
            currentState.copy(lastnameTHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(lastnameTHasError = false)
        }
    }

    fun updateNumber(updateNumber: String) {
        val numberError = getFieldError(updateNumber, FieldT.NumberT)

        _uiState.update { currentState ->
            currentState.copy(
                numberT = updateNumber,
                numberError = numberError
            )
        }

        if (updateNumber != "") _uiState.update { currentState ->
            currentState.copy(numberHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(numberHasError = false)
        }
    }

    fun updateDate(updateDate: String) {
        val dateError = getFieldError(updateDate, FieldT.DateT)

        _uiState.update { currentState ->
            currentState.copy(
                dateT = updateDate,
                dateError = dateError
            )
        }

        if (dateError != "") _uiState.update { currentState ->
            currentState.copy(dateHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(dateHasError = false)
        }
    }

    fun updateCode(updateCode: String) {
        val codeError = getFieldError(updateCode, FieldT.CodeT)

        _uiState.update { currentState ->
            currentState.copy(
                codeT = updateCode,
                codeError = codeError
            )
        }

        if (codeError != "") _uiState.update { currentState ->
            currentState.copy(codeHasError = true)
        } else _uiState.update { currentState ->
            currentState.copy(codeHasError = false)
        }
    }

    fun focusEventUsernameField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.usernameTFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(usernameTFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.usernameTFocusEventsCount == 1) {
            val usernameError = getFieldError(uiState.value.usernameT, FieldT.UsernameT)
            _uiState.update { currentState ->
                currentState.copy(
                    usernameTFocusEventsCount = 2,
                    showUsernameTError = true,
                    usernameTError = usernameError,
                    usernameTHasError = (usernameError != "")
                )
            }
        }
    }

    fun focusEventLastnameField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.lastnameTFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(lastnameTFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.lastnameTFocusEventsCount == 1) {
            val lastnameError = getFieldError(uiState.value.lastnameT, FieldT.LastnameT)
            _uiState.update { currentState ->
                currentState.copy(
                    lastnameTFocusEventsCount = 2,
                    showLastnameTError = true,
                    lastnameTError = lastnameError,
                    lastnameTHasError = (lastnameError != "")
                )
            }
        }
    }

    fun focusEventNumberField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.numberFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(numberFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.numberFocusEventsCount == 1) {
            val emailError = getFieldError(uiState.value.numberT, FieldT.NumberT)
            _uiState.update { currentState ->
                currentState.copy(
                    numberFocusEventsCount = 2,
                    showNumberError = true,
                    numberError = emailError,
                    numberHasError = (emailError != "")
                )
            }
        }
    }

    fun focusEventDateField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.dateFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(dateFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.dateFocusEventsCount == 1) {
            val dateError = getFieldError(uiState.value.dateT, FieldT.DateT)
            _uiState.update { currentState ->
                currentState.copy(
                    dateFocusEventsCount = 2,
                    showDateError = true,
                    dateError = dateError,
                    dateHasError = (dateError != "")
                )
            }
        }
    }

    fun focusEventCodeField(focusEvent: FocusState) {
        if (focusEvent.isFocused && uiState.value.codeFocusEventsCount == 0)
            _uiState.update { currentState ->
                currentState.copy(codeFocusEventsCount = 1)
            }
        else if (!focusEvent.isFocused && uiState.value.codeFocusEventsCount == 1) {
            val codeError = getFieldError(uiState.value.dateT, FieldT.CodeT)
            _uiState.update { currentState ->
                currentState.copy(
                    codeFocusEventsCount = 2,
                    showCodeError = true,
                    codeError = codeError,
                    codeHasError = (codeError != "")
                )
            }
        }
    }

    fun checkData(): Boolean {
        val usernameTError = getFieldError(uiState.value.usernameT, FieldT.UsernameT)
        val lastnameTError = getFieldError(uiState.value.lastnameT, FieldT.LastnameT)
        val numberError = getFieldError(uiState.value.numberT, FieldT.NumberT)
        val dateError = getFieldError(uiState.value.dateT, FieldT.DateT)
        val codeError = getFieldError(uiState.value.codeT, FieldT.CodeT)

        if (
            usernameTError == "" &&
            lastnameTError == "" &&
            numberError == "" &&
            dateError == "" &&
            codeError == ""
        )
        {
            return true
        } else {
            val usernameTHasError = (usernameTError != "")
            val lastnameTHasError = (lastnameTError != "")
            val numberHasError = (numberError != "")
            val dateHasError = (dateError != "")
            val codeHasError = (codeError != "")

            _uiState.update { currentState ->
                currentState.copy(
                    showUsernameTError = usernameTHasError,
                    usernameTHasError = usernameTHasError,
                    usernameTError = usernameTError,

                    showLastnameTError = lastnameTHasError,
                    lastnameTHasError = lastnameTHasError,
                    lastnameTError = lastnameTError,

                    showNumberError = numberHasError,
                    numberHasError = numberHasError,
                    numberError = numberError,

                    showDateError = dateHasError,
                    dateHasError = dateHasError,
                    dateError = dateError,

                    showCodeError = codeHasError,
                    codeHasError = codeHasError,
                    codeError = codeError,
                )
            }
        }
        return false
    }

    private fun getFieldError(value: String, fieldT: FieldT): String {
        if (value.isEmpty()) return "Este campo es obligatorio."
        when (fieldT) {
            FieldT.UsernameT -> {
                val pattern = Regex(".{3,}")
                if (!pattern.matches(value)) return "El nombre debe contener al menos 3 caracteres."
            }
            FieldT.LastnameT -> {
                val pattern = Regex(".{3,}")
                if (!pattern.matches(value)) return "El apellido debe contener al menos 3 caracteres."
            }
            FieldT.NumberT -> {
                val pattern = Regex(".{10,16}")
                if (!pattern.matches(value)) return "El numero de tarjeta debe tener almenos 10 dijitos."
            }
            FieldT.DateT -> {
                val pattern = Regex(".{5}")
                if (!pattern.matches(value)) return "La fecha de vencimiento debe contener  4 caracteres"
            }
            FieldT.CodeT -> {
                val pattern = Regex(".{4}")
                if (!pattern.matches(value)) return "El Codigo debe tener 4 digitos"
            }

            else -> {}
        }
        return ""
    }
}