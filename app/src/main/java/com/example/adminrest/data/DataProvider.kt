package com.example.adminrest.data

import com.example.adminrest.R

object DataProvider {
    val producto =
        Productos(
            id = 1,
            nombre = "Hamburguesa Doble Carne",
            precio = 25000,
            descripcion = "Deliciosa hamburguesa especial de la casa.",
            productoImageId = R.drawable.p1
        )

    val productosList = listOf(
        producto,
        Productos(
            id = 2,
            nombre = "Pizza Napolitana",
            precio = 35000,
            descripcion = "Deliciosa Pizza especial de la casa.",
            productoImageId = R.drawable.p2
        ),
        Productos(
            id = 3,
            nombre = "Espaghettis a la Bolognesa",
            precio = 33000,
            descripcion = "Deliciosa Espaghettis a la Bolgnesa especial de la casa.",
            productoImageId = R.drawable.p3
        ),
        Productos(
            id = 4,
            nombre = "Sopa de Ramen",
            precio = 15000,
            descripcion = "Deliciosa Porción de Noodles al estilo Japonés.",
            productoImageId = R.drawable.p4
        ),
        Productos(
            id = 5,
            nombre = "Pancakes con Miel",
            precio = 13000,
            descripcion = "Porcion grande de Pancakes bañados en Miel",
            productoImageId = R.drawable.p5
        ),
        Productos(
            id = 6,
            nombre = "Porción de Papas a la Francesa",
            precio = 9000,
            descripcion = "Adición de Papas a la Francesa",
            productoImageId = R.drawable.p6
        ),
        Productos(
            id = 7,
            nombre = "Postre de Torta Vienesa",
            precio = 13000,
            descripcion = "Deliciosa Torta Humeda tipo Vienesa",
            productoImageId = R.drawable.p7
        ),
        Productos(
            id = 8,
            nombre = "Porcion de Tacos Mexicanos",
            precio = 15000,
            descripcion = "Deliciosos Tacos Rellenos de Carne, Queso y Vegetales",
            productoImageId = R.drawable.p8
        ),
        Productos(
            id = 9,
            nombre = "Sandwich de Pollo",
            precio = 20000,
            descripcion = "Sandwich relleno de pollo, tomate, lechuga, queso y aderezos",
            productoImageId = R.drawable.p9
        ),
    )
}