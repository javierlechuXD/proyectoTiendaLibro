package constantesSQL;

public class ConstantesSQL {
	
	public final static String SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE = "select id, nombre from tabla_categorias order by nombre asc";
	public final static String SQL_OBTENER_PRODUCTOS_CARRITO = "select libro.id as libro_id,  libro.titulo, libro.precio, productocarrito.cantidad from libro, productocarrito where productocarrito.libro_id = libro.id and productocarrito.carrito_id = :carrito_id ORDER by productocarrito.id asc";
	public final static String BORRAR_PRODUCTOS_CARRITO = "delete from productocarrito where carrito_id = :carrito_id"; 
	public final static String OBTENER_TOTAL_LIBROS = "select count(id) from libro where titulo like :titulo and alta = 1";
}
