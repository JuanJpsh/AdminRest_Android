package com.example.adminrest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.adminrest.data.Productos
import com.example.adminrest.ui.theme.CreamOrange
import com.example.adminrest.ui.theme.IntermediateOrange
import com.example.adminrest.ui.theme.Orange

@Composable
fun ProductoListItem(productos: Productos) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = IntermediateOrange,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            ProductoImagen(productos = productos)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = productos.nombre, style = typography.h6)
                Text(text = "Precio: 20.000$", style = typography.caption)
            }
        }
    }
}

@Composable
private fun ProductoImagen(productos: Productos) {
    Image(
        painter = painterResource(id = productos.productoImageId),
        contentDescription = null,
        contentScale =ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}