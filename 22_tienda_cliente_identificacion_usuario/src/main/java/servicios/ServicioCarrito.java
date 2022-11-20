package servicios;

import java.util.List;
import java.util.Map;

import modelo.Usuario;

public interface ServicioCarrito {

	void agregarProducto(Usuario u, int idProducto, int cantidad);
	
	List<Map<String, Object>> obtenerProductoCarrito(Usuario u);
	
}
