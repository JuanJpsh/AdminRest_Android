package com.example.adminrest

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adminrest.ui.BlankScreen
import com.example.adminrest.ui.BlankViewModel
import com.example.adminrest.ui.LoginScreen
import com.example.adminrest.ui.LoginViewModel

enum class AdminrestScreen(@StringRes val title: Int) {
    Login(title = R.string.app_login),
    Blank(title = R.string.app_blank)
}

@Composable
fun AdminrestAppBar(
    currentScreen: AdminrestScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.btn_back)
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
        }
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
                    modifier = Modifier.fillMaxSize(),
                )
            }
            composable(route = AdminrestScreen.Blank.name) {
                BlankScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}