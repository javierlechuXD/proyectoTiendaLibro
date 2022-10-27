package servicios;

import java.util.List;
import java.util.Map;

import modelo.Usuario;

public interface ServicioCarrito {
	
	void agregarProducto(Usuario u, int cantidad, int idProducto);
	
	List<Map<String, Object>> obtenerProductosCarrito(Usuario usuario);
}
