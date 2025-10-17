data class Cliente(
    val nombre: String, // Nombre del cliente
    val telefono: String, // Teléfono del cliente
    val direccion: String, // Dirección de envío
    val email: String, // Correo electrónico del cliente
    val historialPedidos: MutableList<Boleta> = mutableListOf() // Lista de boletas (pedidos) del cliente
) {
    // Función para agregar un pedido al historial
    fun agregarPedido(boleta: Boleta) {
        historialPedidos.add(boleta)
    }

    // Función para obtener el total gastado por el cliente
    fun obtenerTotalGastado(): Double {
        return historialPedidos.sumOf { it.precioTotal }
    }

    // Función para obtener el número de pedidos realizados
    fun obtenerNumeroDePedidos(): Int {
        return historialPedidos.size
    }
}
