package com.example.restorinijapixini_joseretamal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.restorinijapixini_joseretamal.ui.theme.RestoriniJapixini_JoseRetamalTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
fun main() {
    // Crear un cliente
    val cliente = Cliente(
        nombre = "Juan Pérez",
        telefono = "123456789",
        direccion = "Calle Ficticia 123",
        email = "juanperez@example.com"
    )

    // Crear un carrito y agregar productos
    val carrito = Carrito(cliente)
    carrito.agregarProducto(pizza, 2)
    carrito.agregarProducto(hamburguesa, 3)

    // Crear una boleta con el carrito
    val boleta = Boleta(cliente, carrito, 0.0)
    boleta.calcularPrecio()

    // Agregar el pedido al historial del cliente
    cliente.agregarPedido(boleta)

    // Mostrar detalles del cliente
    println("Cliente: ${cliente.nombre}")
    println("Total gastado por el cliente: ${cliente.obtenerTotalGastado()}")
    println("Número de pedidos realizados: ${cliente.obtenerNumeroDePedidos()}")

    // Ver los detalles del último pedido
    println("Último pedido total: ${boleta.precioTotal}")

    val pizza = Producto(
        id = 1,
        nombre = "Pizza Margherita",
        precio = 12.0,
        descripcion = "Pizza con tomate, mozzarella y albahaca fresca.",
        categoria = Categoria.PLATO_PRINCIPAL,
        opcionesPersonalizadas = listOf("Tamaño: S, M, L", "Masa: Fina, Gruesa", "Agregar ingredientes extra")
    )

    val hamburguesa = Producto(
        id = 2,
        nombre = "Hamburguesa Clásica",
        precio = 8.0,
        descripcion = "Hamburguesa con carne de res, queso, lechuga, tomate y cebolla.",
        categoria = Categoria.PLATO_PRINCIPAL
    )

    val cocaCola = Producto(
        id = 3,
        nombre = "Coca-Cola",
        precio = 2.5,
        descripcion = "Bebida refrescante de cola.",
        categoria = Categoria.BEBIDA,
        disponible = true
    )

    // Mostrar información de los productos
    println("Producto 1: ${pizza.nombre}")
    println("Descripción: ${pizza.descripcion}")
    println("Precio: \$${pizza.precio}")
    println("Categoría: ${pizza.categoria}")
    println("Opciones personalizadas: ${pizza.opcionesPersonalizadas.joinToString(", ")}")
    println("Disponible: ${pizza.disponible}")
    println()

    println("Producto 2: ${hamburguesa.nombre}")
    println("Descripción: ${hamburguesa.descripcion}")
    println("Precio: \$${hamburguesa.precio}")
    println("Categoría: ${hamburguesa.categoria}")
    println("Disponible: ${hamburguesa.disponible}")
    println()

    println("Producto 3: ${cocaCola.nombre}")
    println("Descripción: ${cocaCola.descripcion}")
    println("Precio: \$${cocaCola.precio}")
    println("Categoría: ${cocaCola.categoria}")
    println("Disponible: ${cocaCola.disponible}")

    // Mostrar detalles de los productos
    println(detallePizza.mostrarDetalle())
    println(detalleHamburguesa.mostrarDetalle())

    // Si el producto no estuviera disponible, se podría mostrar un mensaje diferente
    val detallePizzaFueraStock = DetalleProducto(
        producto = pizza,
        cantidad = 1,
        descripcion = "Pizza de tamaño grande con queso extra y pepperoni.",
        opciones = listOf("Tamaño grande", "Masa fina", "Queso extra", "Pepperoni"),
        disponible = false
    )

    // Mostrar el detalle del producto fuera de stock
    println("\nProducto fuera de stock:")
    println(detallePizzaFueraStock.mostrarDetalle())

    val mesa1 = Mesa(numero = 1, capacidad = 4)
    val mesa2 = Mesa(numero = 2, capacidad = 2)

    // Mostrar estado inicial de las mesas
    println(mesa1.mostrarEstado())
    println(mesa2.mostrarEstado())

    // Reservar la mesa 1 para Juan Pérez
    mesa1.reservar(cliente1)

    // Mostrar estado después de la reserva
    println("\nDespués de reservar:")
    println(mesa1.mostrarEstado())

    // Intentar ocupar la mesa 2 para Maria Gómez
    mesa2.ocupar(cliente2)

    // Mostrar estado después de ocupar la mesa 2
    println("\nDespués de ocupar la mesa 2:")
    println(mesa2.mostrarEstado())

    // Liberar la mesa 1
    mesa1.liberar()

    // Mostrar estado después de liberar la mesa 1
    println("\nDespués de liberar la mesa 1:")
    println(mesa1.mostrarEstado())
}
