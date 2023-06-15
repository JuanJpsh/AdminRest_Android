package com.example.adminrest.ui

import android.print.PrintAttributes.Margins
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adminrest.R
import com.example.adminrest.ui.theme.ADMINRESTTheme


@Composable
fun PaymentScreen(
    onSubscriptionButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    paymentViewModel: PaymentViewModel = viewModel(),

    ) {
    val paymentUiState by paymentViewModel.uiState.collectAsState()

    Column(
        modifier = modifier.padding(32.dp),
    ) {
        Text(
            text = stringResource(R.string.txt_payment_v1),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
        Text(text = stringResource(
            R.string.txt_payment_v2),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.pago),
                contentDescription = "Imagen",
                modifier = Modifier.size(150.dp)
            )

        }
        TextField(
            value = paymentUiState.usernameT,
            onValueChange = { paymentViewModel.updateUsernameT(it) },
            label = { Text(stringResource(R.string.txt_payment_v3)) },
            isError = (paymentUiState.showUsernameTError && paymentUiState.usernameTHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> paymentViewModel.focusEventUsernameField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Text(
            text = if (paymentUiState.showUsernameTError && paymentUiState.usernameTHasError)
                paymentUiState.usernameTError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        TextField(
            value = paymentUiState.lastnameT,
            onValueChange = { paymentViewModel.updateLastnameT(it) },
            label = { Text(stringResource(R.string.txt_payment_v4)) },
            isError = (paymentUiState.showLastnameTError && paymentUiState.lastnameTHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> paymentViewModel.focusEventLastnameField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Text(
            text = if (paymentUiState.showLastnameTError && paymentUiState.lastnameTHasError)
                paymentUiState.lastnameTError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        TextField(
            value = paymentUiState.numberT,
            onValueChange = { paymentViewModel.updateNumber(it) },
            label = { Text(stringResource(R.string.txt_payment_v5)) },
            isError = (paymentUiState.showNumberError && paymentUiState.numberHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> paymentViewModel.focusEventNumberField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = if (paymentUiState.showNumberError && paymentUiState.numberHasError)
                paymentUiState.numberError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,

            )
        TextField(
            value = paymentUiState.dateT,
            onValueChange = { paymentViewModel.updateDate(it) },
            label = { Text(stringResource(R.string.txt_payment_v6)) },
            isError = (paymentUiState.showDateError && paymentUiState.dateHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent -> paymentViewModel.focusEventDateField(focusEvent) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )


        Text(
            text = if (paymentUiState.showDateError && paymentUiState.dateHasError)
                paymentUiState.dateError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        TextField(
            value = paymentUiState.codeT,
            onValueChange = { paymentViewModel.updateCode(it) },
            label = { Text(stringResource(R.string.txt_payment_v7)) },
            isError = (paymentUiState.showCodeError && paymentUiState.codeHasError),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusEvent ->
                    paymentViewModel.focusEventCodeField(
                        focusEvent
                    )
                },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = if (paymentUiState.showCodeError && paymentUiState.codeHasError)
                paymentUiState.codeError else "",
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = stringResource(R.string.txt_payment_v9),
            textAlign = TextAlign.Justify,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            )
        )

        Text(
            text = stringResource(R.string.txt_payment_v10),
            textAlign = TextAlign.Justify,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            )
        )

        Spacer(Modifier.height(10.dp))
        Button(
            onClick = { if (paymentViewModel.checkData()) onSubscriptionButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(stringResource(R.string.txt_payment_v8))


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentPreview() {
    ADMINRESTTheme {
        PaymentScreen(
            onSubscriptionButtonClicked = {},
            Modifier
        )
    }
}
