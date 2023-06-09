package com.example.adminrest

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adminrest.ui.theme.ADMINRESTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ADMINRESTTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LoginView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ADMINRESTTheme {
        LoginView()
    }
}

@Composable
fun LoginView() {
    Column(
        modifier = Modifier
            .padding(32.dp)
    ) {
        val modifier = Modifier.align(Alignment.CenterHorizontally)
        Spacer(modifier = Modifier.weight(1f))
        Logo(modifier)
        Spacer(modifier = Modifier.weight(1f))
        LoginForm(modifier)
        forgotPassword(modifier)
        Spacer(modifier = Modifier.weight(1f))
        register(modifier)
    }
}

@Composable
fun LoginForm(modifier: Modifier) {
    var email by remember { mutableStateOf("") }
    var showEmailError by remember { mutableStateOf(false) }
    var isFocusedEmail by remember { mutableStateOf(false) }

    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(stringResource(R.string.email)) },
        isError = showEmailError,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent { focusEvent ->
                if (!focusEvent.isFocused && isFocusedEmail) {
                    if (getEmailError(email) == "") showEmailError = false
                    else showEmailError = true
                }
                isFocusedEmail = focusEvent.isFocused
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

    Text(
        text = if (showEmailError) getEmailError(email) else "",
        color = MaterialTheme.colors.error,
        style = MaterialTheme.typography.caption,
    )

    Spacer(Modifier.height(15.dp))

    var password by remember { mutableStateOf("") }
    var showPasswordError by remember { mutableStateOf(false) }
    var isFocusedPassword by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(stringResource(R.string.password)) },
        isError = showPasswordError,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent { focusEvent ->
                if (!focusEvent.isFocused && isFocusedPassword) {
                    if (getPasswordError(password) == "") showPasswordError = false
                    else showPasswordError = true
                }
                isFocusedPassword = focusEvent.isFocused
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Text(
        text = if (showPasswordError) getPasswordError(password) else "",
        color = MaterialTheme.colors.error,
        style = MaterialTheme.typography.caption,
    )

    Spacer(Modifier.height(8.dp))
    
    Button(
        onClick = {
            val emailError = getEmailError(email)
            val passwordError = getPasswordError(password)

            if (emailError == "" && passwordError == ""){

            } else {
                if (emailError != "") showEmailError = true
                if (passwordError != "") showPasswordError = true
            }
        },
        modifier.fillMaxWidth()) {
        Text(stringResource(R.string.loginButton))
    }
}

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

@Composable
fun forgotPassword(modifier: Modifier) {
    Text(stringResource(R.string.forgotPassword), modifier)
}

@Composable
fun register(modifier: Modifier) {
    Text(stringResource(R.string.registerText1), modifier)
    Text(stringResource(R.string.registerText2), modifier)
    Spacer(Modifier.height(12.dp))
    Button(
        onClick = { /*TODO*/ },
        modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
        )
    ) {
        Text(stringResource(R.string.registerButton))
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