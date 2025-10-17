package com.example.restorinijapixini_joseretamal.model

data class DetalleProducto(
    val producto: Producto, // El producto básico
    var cantidad: Int, // La cantidad del producto que el cliente ha agregado al carrito
    val descripcion: String, // Descripción del producto (puede incluir detalles sobre los ingredientes, preparación, etc.)
    val opciones: List<String> = listOf(), // Opciones personalizadas del producto (ej: tamaño, masa, ingredientes adicionales)
    val disponible: Boolean = true // Si el producto está disponible o no
) {
    // Función para mostrar la información detallada del producto
    fun mostrarDetalle(): String {
        val opcionesStr = if (opciones.isNotEmpty()) "Opciones: ${opciones.joinToString(", ")}" else "Sin opciones adicionales"
        return """
            Producto: ${producto.nombre}
            Precio: \$${producto.precio}
            Descripción: $descripcion
            Cantidad: $cantidad
            $opcionesStr
            Disponible: ${if (disponible) "Sí" else "No"}
        """.trimIndent()
    }
}
