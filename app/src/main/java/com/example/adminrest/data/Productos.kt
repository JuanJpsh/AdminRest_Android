package com.example.adminrest.data

data class Productos(
    val id: Int,
    val nombre: String,
    val precio: Int,
    val descripcion: String,
    val productoImageId: Int = 0
)
