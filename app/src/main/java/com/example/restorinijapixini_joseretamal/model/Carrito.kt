class Carrito(
    val cliente: Cliente, // Relación con el cliente
    val productos: MutableList<ItemCarrito> = mutableListOf() // Lista mutable de productos en el carrito
) {
    // Función para agregar un producto al carrito
    fun agregarProducto(producto: Producto, cantidad: Int) {
        // Verificamos si el producto ya está en el carrito
        val itemExistente = productos.find { it.producto == producto }

        if (itemExistente != null) {
            // Si el producto ya está, solo aumentamos la cantidad
            itemExistente.cantidad += cantidad
        } else {
            // Si no está en el carrito, lo agregamos
            productos.add(ItemCarrito(producto, cantidad))
        }
    }

    // Función para eliminar un producto del carrito
    fun eliminarProducto(producto: Producto) {
        productos.removeAll { it.producto == producto }
    }

    // Función para vaciar el carrito
    fun vaciarCarrito() {
        productos.clear()
    }

    // Función para calcular el precio total de todos los productos en el carrito
    fun calcularTotal(): Double {
        return productos.sumOf { it.producto.precio * it.cantidad }
    }

    // Función para obtener la cantidad total de productos en el carrito
    fun obtenerCantidadTotal(): Int {
        return productos.sumOf { it.cantidad }
    }
}

// Clase auxiliar para representar un item en el carrito (Producto + cantidad)
data class ItemCarrito(
    val producto: Producto,
    var cantidad: Int
)

// Clase Producto, ejemplo de cómo podría ser la clase Producto
data class Producto(
    val nombre: String,
    val precio: Double
)
