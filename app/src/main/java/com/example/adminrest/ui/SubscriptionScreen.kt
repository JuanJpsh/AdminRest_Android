package com.example.adminrest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adminrest.R
import com.example.adminrest.ui.theme.ADMINRESTTheme
import java.util.concurrent.Flow.Subscription
import kotlin.coroutines.coroutineContext
data class PlanData(val category: String, val value: String)
var selectedPlan: String? = null

@Composable
fun SubscriptionScreen(
    onSubscriptionButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    paymentViewModel: PaymentViewModel = viewModel(),
) {
    var selectedPlan by remember { mutableStateOf("") }
    var planPrice by remember { mutableStateOf(0) }
    var planNumber by remember { mutableStateOf("") }
    var planAgregado by remember { mutableStateOf("") }
    var planEstadisticas by remember { mutableStateOf("") }
    var planDomicilio by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(32.dp),
    ) {
        Text(
            text = stringResource(R.string.txt_subscription_v1),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
        Spacer(Modifier.height(5.dp))
        Text(text = stringResource(
            R.string.txt_subscription_v2),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp

            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.chulo),
                contentDescription = "Imagen",
                modifier = Modifier.size(50.dp)

            )
            Text(
                text = stringResource(R.string.txt_subscription_v3),
                modifier = Modifier.padding(start = 1.dp),
                textAlign = TextAlign.Left,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp)
            )
        }
        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(R.drawable.chulo),
                contentDescription = "Imagen",
                modifier = Modifier.size(50.dp)

            )
            Text(
                text = stringResource(R.string.txt_subscription_v4),
                modifier = Modifier.padding(start = 3.dp),
                textAlign = TextAlign.Left,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp)
            )
        }

        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(R.drawable.chulo),
                contentDescription = "Imagen",
                modifier = Modifier.size(50.dp)

            )
            Text(
                text = stringResource(R.string.txt_subscription_v5),
                modifier = Modifier.padding(start = 3.dp),
                textAlign = TextAlign.Left,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp)
            )
        }

        Spacer(Modifier.height(16.dp))
        SubscriptionPlans(
            selectedPlan = selectedPlan,
            onPlanSelected = { plan, price,number,agregado, estadistica, domis ->
                selectedPlan = plan
                planPrice = price
                planNumber = number
                planAgregado = agregado
                planEstadisticas = estadistica
                planDomicilio = domis
            }
        )
        Column (modifier = Modifier
                .padding(16.dp)
            .background(Color.White)
        ) {

            Spacer(Modifier.height(16.dp))
            Text(
                text = "Plan seleccionado: $selectedPlan",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Precio mensual:  $planPrice",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Numero máximo de restaurantes para gestionar: $planNumber",
                textAlign = TextAlign.Center,
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Precio mensual restaurante agregado:  $planAgregado",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Comparacion estadisticas restaurantes:  $planEstadisticas",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Solicitud domicilios disponibles:  $planDomicilio",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }



        Spacer(Modifier.height(1.dp))
        Text(text = stringResource(
            R.string.txt_subscription_v6),
            textAlign = TextAlign.Justify,
            style = TextStyle(
                fontSize = 12.sp)
        )
        Spacer(Modifier.height(3.dp))
        Button(
            onClick = {onSubscriptionButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Siguiente")
        }


    }
}


@Composable
fun SubscriptionPlans(
    selectedPlan: String,
    onPlanSelected: (String, Int,String,String,String,String) -> Unit
) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PlanCard(
            title = "Básico",
            price = 20000,
            number = "1",
            agregado = "NO",
            estadistica = "No",
            domis = "No",
            isSelected = selectedPlan == "Básico",
            onPlanSelected = onPlanSelected


        )
        PlanCard(
            title = "Estándar",
            price = 36000,
            number = "3",
            agregado = "$15000",
            estadistica = "si",
            domis = "Si",
            isSelected = selectedPlan == "Estándar",
            onPlanSelected = onPlanSelected
        )
        PlanCard(
            title = "Premium",
            price = 60000,
            number = "ilimitado",
            agregado = "$18000",
            estadistica = "Si",
            domis = "No",
            isSelected = selectedPlan == "Premium",
            onPlanSelected = onPlanSelected
        )
    }
}
@Composable
fun PlanCard(
    title: String,
    price: Int,
    number: String,
    agregado: String,
    estadistica: String,
    domis: String,
    isSelected: Boolean,
    onPlanSelected: (String, Int,String,String,String,String) -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onPlanSelected(title, price, number, agregado, estadistica, domis) }
            .padding(1.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFFF3211))
                .padding(1.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Precio: $price",
                color = Color.White,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubscriptionPreview() {
    ADMINRESTTheme {
        SubscriptionScreen(
            onSubscriptionButtonClicked = {},
            Modifier
        )
    }
}