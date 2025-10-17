package com.example.restorinijapixini_joseretamal.model

data class Producto(
    val id: Int, // Identificador único del producto
    val nombre: String, // Nombre del producto (ej. "Pizza", "Hamburguesa")
    val precio: Double, // Precio base del producto
    val descripcion: String = "", // Descripción del producto
    val categoria: Categoria = Categoria.OTRO, // Categoría del producto (por ejemplo, "Plato principal", "Postre", etc.)
    val disponible: Boolean = true, // Indica si el producto está disponible en el menú
    val opcionesPersonalizadas: List<String> = listOf() // Opciones personalizadas que el cliente puede elegir (ej. "Tamaño", "Ingredientes extra")
)

enum class Categoria {
    ENTRADA,
    PLATO_PRINCIPAL,
    POSTRE,
    BEBIDA,
    OTRO // Para productos que no encajan en las categorías anteriores
}
