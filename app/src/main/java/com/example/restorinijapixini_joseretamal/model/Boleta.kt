package com.example.restorinijapixini_joseretamal.model

class Boleta(
    val cliente: Cliente,
    val carrito: Carrito,
    var precioTotal: Double // Cambié a 'var' para poder modificar el precio total
) {
    fun calcularPrecio(): Double {
        // Calculamos el precio total de manera más clara
        val total = carrito.producto.sumOf { it.producto.precio * it.cantidad }

        // Asignamos el resultado a precioTotal
        precioTotal = total

        // Retornamos el total calculado
        return total
    }
}
