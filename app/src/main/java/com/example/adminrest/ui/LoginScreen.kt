package com.example.adminrest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adminrest.ui.theme.ADMINRESTTheme
import com.example.adminrest.R

@Composable
fun LoginScreen(
    onLoginButtonClicked: (String) -> Unit,
    onRegisterButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier, color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .padding(32.dp)
        ) {
            val centerModifier = Modifier.align(Alignment.CenterHorizontally)
            Spacer(modifier = Modifier.weight(1f))
            Logo(centerModifier)
            Spacer(modifier = Modifier.weight(1f))
            LoginForm(onLoginButtonClicked, centerModifier)
            ForgotPassword(centerModifier)
            Spacer(modifier = Modifier.weight(1f))
            Register(onRegisterButtonClicked = onRegisterButtonClicked, modifier = centerModifier)
        }
    }
}

@Composable
fun LoginForm(
    onLoginButtonClicked: (String) -> Unit,
    modifier: Modifier,
    loginViewModel: LoginViewModel = viewModel()
) {
    val loginUiState by loginViewModel.uiState.collectAsState()

    TextField(
        value = loginUiState.email,
        onValueChange = { loginViewModel.updateEmail(it) },
        label = { Text(stringResource(R.string.lbl_email)) },
        isError = (loginUiState.showEmailError && loginUiState.emailHasError),
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent { focusEvent -> loginViewModel.focusEventEmailField(focusEvent) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

    Text(
        text = if (loginUiState.showEmailError && loginUiState.emailHasError)
            loginUiState.emailError else "",
        color = MaterialTheme.colors.error,
        style = MaterialTheme.typography.caption,
    )

    Spacer(Modifier.height(15.dp))

    TextField(
        value = loginUiState.password,
        onValueChange = { loginViewModel.updatePassword(it) },
        label = { Text(stringResource(R.string.lbl_password)) },
        isError = (loginUiState.showPasswordError && loginUiState.passwordHasError),
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent { focusEvent -> loginViewModel.focusEventPasswordField(focusEvent) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Text(
        text = if (loginUiState.showPasswordError && loginUiState.passwordHasError)
            loginUiState.passwordError else "",
        color = MaterialTheme.colors.error,
        style = MaterialTheme.typography.caption,
    )

    Spacer(Modifier.height(8.dp))

    Button(
        onClick = { if (loginViewModel.checkCredentials()) onLoginButtonClicked("123") },
        modifier.fillMaxWidth())
    {
        Text(stringResource(R.string.btn_login))
    }
}
@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(stringResource(R.string.lnk_forgotPassword), modifier)
}

@Composable
fun Register(
    modifier: Modifier,
    onRegisterButtonClicked: () -> Unit
) {
    Text(stringResource(R.string.txt_register1), modifier)
    Text(stringResource(R.string.txt_register2), modifier)
    Spacer(Modifier.height(6.dp))
    Button(
        onClick = { onRegisterButtonClicked() },
        modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
        )
    ) {
        Text(stringResource(R.string.btn_register))
    }
}

@Composable
fun Logo(modifier: Modifier) {
    val image = painterResource(R.drawable.logo)
    Image(
        painter = image,
        contentDescription = null,
        modifier
            .size(140.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ADMINRESTTheme {
        LoginScreen(
            onLoginButtonClicked = {},
            onRegisterButtonClicked = {}
        )
    }
}