package com.example.restorinijapixini_joseretamal.model

enum class EstadoMesa {
    LIBRE, OCUPADA, RESERVADA
}

data class Mesa(
    val numero: Int, // Número o identificador de la mesa
    val capacidad: Int, // Cuántas personas caben en la mesa
    var estado: EstadoMesa = EstadoMesa.LIBRE, // Estado de la mesa (libre, ocupada, reservada)
    var cliente: Cliente? = null, // Cliente asignado a la mesa (si está ocupada o reservada)
    val historialPedidos: MutableList<Boleta> = mutableListOf() // Historial de pedidos para esta mesa
) {
    // Función para reservar la mesa
    fun reservar(cliente: Cliente): Boolean {
        return if (estado == EstadoMesa.LIBRE) {
            estado = EstadoMesa.RESERVADA
            this.cliente = cliente
            println("Mesa ${numero} reservada para ${cliente.nombre}")
            true
        } else {
            println("La mesa ${numero} no está disponible para reserva.")
            false
        }
    }

    // Función para liberar la mesa
    fun liberar(): Boolean {
        return if (estado == EstadoMesa.OCUPADA || estado == EstadoMesa.RESERVADA) {
            estado = EstadoMesa.LIBRE
            cliente = null
            println("Mesa ${numero} ahora está libre.")
            true
        } else {
            println("La mesa ${numero} ya está libre.")
            false
        }
    }

    // Función para ocupar la mesa
    fun ocupar(cliente: Cliente): Boolean {
        return if (estado == EstadoMesa.LIBRE) {
            estado = EstadoMesa.OCUPADA
            this.cliente = cliente
            println("Mesa ${numero} ocupada por ${cliente.nombre}")
            true
        } else {
            println("La mesa ${numero} no está disponible para ocupar.")
            false
        }
    }

    // Función para agregar un pedido al historial de la mesa
    fun agregarPedido(boleta: Boleta) {
        historialPedido
