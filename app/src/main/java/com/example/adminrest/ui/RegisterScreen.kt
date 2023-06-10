package com.example.adminrest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adminrest.ui.theme.ADMINRESTTheme
import com.example.adminrest.R

@Composable
fun RegisterScreen(
    onSubscriptionButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    registerViewModel: RegisterViewModel = viewModel()
) {
    val registerUiState by registerViewModel.uiState.collectAsState()

    Column(
        modifier = modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.txt_register_v1),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )
        )
        Spacer(Modifier.height(12.dp))
        Text(text = stringResource(
            R.string.txt_register_v2),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Text(text = stringResource(
            R.string.txt_register_v3),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = registerUiState.username,
            onValueChange = { registerViewModel.updateUsername(it) },
            label = { Text(stringResource(R.string.lbl_user_name)) },
            isError = (registerUiState.showUsernameError && registerUiState.usernameHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> registerViewModel.focusEventUsernameField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Text(
            text = if (registerUiState.showUsernameError && registerUiState.usernameHasError)
                registerUiState.usernameError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Spacer(Modifier.height(15.dp))
        TextField(
            value = registerUiState.lastname,
            onValueChange = { registerViewModel.updateLastname(it) },
            label = { Text(stringResource(R.string.lbl_user_lastname)) },
            isError = (registerUiState.showLastnameError && registerUiState.lastnameHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> registerViewModel.focusEventLastnameField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Text(
            text = if (registerUiState.showLastnameError && registerUiState.lastnameHasError)
                registerUiState.lastnameError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Spacer(Modifier.height(15.dp))
        TextField(
            value = registerUiState.email,
            onValueChange = { registerViewModel.updateEmail(it) },
            label = { Text(stringResource(R.string.lbl_email)) },
            isError = (registerUiState.showEmailError && registerUiState.emailHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> registerViewModel.focusEventEmailField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Text(
            text = if (registerUiState.showEmailError && registerUiState.emailHasError)
                registerUiState.emailError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Spacer(Modifier.height(15.dp))
        TextField(
            value = registerUiState.password,
            onValueChange = { registerViewModel.updatePassword(it) },
            label = { Text(stringResource(R.string.lbl_password)) },
            isError = (registerUiState.showPasswordError && registerUiState.passwordHasError),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> registerViewModel.focusEventPasswordField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Text(
            text = if (registerUiState.showPasswordError && registerUiState.passwordHasError)
                registerUiState.passwordError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Spacer(Modifier.height(15.dp))
        TextField(
            value = registerUiState.repeatPassword,
            onValueChange = { registerViewModel.updateRepeatPassword(it) },
            label = { Text(stringResource(R.string.lbl_repeat_password)) },
            isError = (registerUiState.showRepeatPasswordError && registerUiState.repeatPasswordHasError),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> registerViewModel.focusEventRepeatPasswordField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Text(
            text = if (registerUiState.showRepeatPasswordError && registerUiState.repeatPasswordHasError)
                registerUiState.repeatPasswordError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Button(
            onClick = { if (registerViewModel.checkData()) onSubscriptionButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.btn_continue))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    ADMINRESTTheme {
        RegisterScreen(
            onSubscriptionButtonClicked = {},
            Modifier
        )
    }
}