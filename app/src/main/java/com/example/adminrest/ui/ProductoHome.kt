package com.example.adminrest.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.adminrest.data.DataProvider

@Composable
fun ProductoHomeContent() {
    val productos = remember{ DataProvider.productosList}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = productos,
            itemContent = {
                ProductoListItem(productos = it)
            }
        )
    }
}