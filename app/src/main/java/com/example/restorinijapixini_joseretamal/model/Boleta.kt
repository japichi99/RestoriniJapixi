package com.example.restorinijapixini_joseretamal.model

class Boleta (
    val ciente: Cliente,
    val carrito: Carrito,
    val precioTotal: Double,
){
    fun calcularPrecio() : Double{
        var total = carrito.producto.sumOf { it.producto.precio * it.cantidad }. Double()
        precioTotal = total
        return total
    }
}