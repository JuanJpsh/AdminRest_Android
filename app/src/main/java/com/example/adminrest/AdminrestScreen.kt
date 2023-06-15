package com.example.adminrest

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adminrest.ui.BlankScreen
import com.example.adminrest.ui.BlankViewModel
import com.example.adminrest.ui.LoginScreen
import com.example.adminrest.ui.PaymentScreen
import com.example.adminrest.ui.RegisterScreen
import com.example.adminrest.ui.SubscriptionScreen

enum class AdminrestScreen(@StringRes val title: Int) {
    Login(title = R.string.nav_login),
    Register(title = R.string.nav_register),
    Subscription(title = R.string.nav_subscription),
    Payment(title = R.string.nav_payment),
    Blank(title = R.string.nav_blank),
}

@Composable
fun AdminrestAppBar(
    currentScreen: AdminrestScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            if (currentScreen != AdminrestScreen.Login){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.btn_login),
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                navigateUp()
                            }
                    )
                }
            } },
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.cream_logo),
                        contentDescription = stringResource(R.string.des_logo),
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun AdminrestApp(
    viewModel: BlankViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AdminrestScreen.valueOf(
backStackEntry?.destination?.route ?:AdminrestScreen.Login.name
    )

    Scaffold(
        topBar = {
            if (currentScreen != AdminrestScreen.Login) {
                AdminrestAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        },
    ) {innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = AdminrestScreen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AdminrestScreen.Login.name) {
                LoginScreen(
                    onLoginButtonClicked = {
                        navController.navigate(AdminrestScreen.Blank.name)
                    },
                    onRegisterButtonClicked = {
                        navController.navigate(AdminrestScreen.Register.name)
                    },
                    modifier = Modifier.fillMaxSize(),
                )
            }
            composable(route = AdminrestScreen.Blank.name) {
                BlankScreen(
                    /*modifier = Modifier
                        .fillMaxSize()*/
                )
            }
            composable(route = AdminrestScreen.Register.name) {
                RegisterScreen(
                    onSubscriptionButtonClicked = {
                        navController.navigate(AdminrestScreen.Subscription.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = AdminrestScreen.Subscription.name) {
                SubscriptionScreen(
                    onSubscriptionButtonClicked = {
                        navController.navigate(AdminrestScreen.Payment.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = AdminrestScreen.Payment.name) {
                PaymentScreen(
                    onSubscriptionButtonClicked = {
                        navController.navigate(AdminrestScreen.Blank.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}