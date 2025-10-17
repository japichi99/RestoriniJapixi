package com.example.restorinijapixini_joseretamal.model

data class Reserva(
    val idReserva: Int, // Identificador único para la reserva
    val cliente: Cliente, // El cliente que realiza la reserva
    val mesa: Mesa, // La mesa reservada
    val fechaReserva: LocalDateTime, // Fecha y hora de la reserva
    var confirmada: Boolean = false, // Si la reserva ha sido confirmada o no
    val especialRequests: String = "" // Solicitudes especiales (por ejemplo, preferencias de comida, ubicación en el restaurante, etc.)
) {
    // Función para confirmar la reserva
    fun confirmarReserva(): Boolean {
        return if (!confirmada) {
            confirmada = true
            mesa.reservar(cliente) // Reservamos la mesa para el cliente
            println("Reserva confirmada para ${cliente.nombre} en la mesa ${mesa.numero} el ${fechaReserva}")
            true
        } else {
            println("La reserva ya está confirmada.")
            false
        }
    }

    // Función para cancelar la reserva
    fun cancelarReserva(): Boolean {
        return if (confirmada) {
            confirmada = false
            mesa.liberar() // Liberamos la mesa
            println("Reserva cancelada para ${cliente.nombre}. La mesa ${mesa.numero} está ahora libre.")
            true
        } else {
            println("La reserva no está confirmada, por lo tanto no se puede cancelar.")
            false
        }
    }

    // Función para mostrar la información de la reserva
    fun mostrarInfoReserva(): String {
        return """
            Reserva ID: $idReserva
            Cliente: ${cliente.nombre}
            Mesa: ${mesa.numero}
            Fecha y Hora: $fechaReserva
            Confirmada: ${if (confirmada) "Sí" else "No"}
            Solicitudes Especiales: $especialRequests
        """.trimIndent()
    }
}
