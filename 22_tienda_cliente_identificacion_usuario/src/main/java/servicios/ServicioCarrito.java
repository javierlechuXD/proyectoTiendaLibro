package servicios;

import modelo.Usuario;

public interface ServicioCarrito {
	
	void agregarProducto(Usuario u, int cantidad, int idProducto);
}
