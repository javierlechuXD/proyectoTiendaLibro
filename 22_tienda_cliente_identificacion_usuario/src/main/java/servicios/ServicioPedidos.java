package servicios;

import datos.serviciosWEB.ResumenPedido;
import modelo.Usuario;

public interface ServicioPedidos {

	void procesarPaso1(String nombreCompleto, String direccion, String provincia, Usuario usuario);
	
	void procesarPaso2(String titular, String numero, Usuario usuario);
	
	ResumenPedido obtenerResumenDelPedido(Usuario usuario);
	
	void confirmarPedido(Usuario usuario);
}
