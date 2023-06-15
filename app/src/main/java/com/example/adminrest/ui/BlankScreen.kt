package com.example.adminrest.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BlankScreen(
    /*modifier: Modifier = Modifier*/
) {
    /*Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Hola1")
        Text(text = "Hola2")
    }*/
    Scaffold(
        content = {
            ProductoHomeContent()
        }
    )
}