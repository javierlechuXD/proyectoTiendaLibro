package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import datos.serviciosWEB.ResumenPedido;
import modelo.Usuario;
import servicios.ServicioPedidos;

@Controller
@RequestMapping("ServicioWebPedidos/")
public class ServicioWebPedidos {
	
	@Autowired
	private ServicioPedidos servicioPedidos;

	@RequestMapping("paso1")
	public ResponseEntity<String> paso1(String nombre, String direccion, String provincia, HttpServletRequest request) {
		String respuesta = "";
		servicioPedidos.procesarPaso1(nombre, direccion, provincia, (Usuario)request.getSession().getAttribute("usuario"));
		respuesta = "ok";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}// end paso 1
	
	@RequestMapping("paso2")
	public ResponseEntity<String> paso2(String titular, String numero, HttpServletRequest request) {
		// Como este es el último paso, si todo ha ido bien, aprovechamos y devolvemos a la parte cliente un resumen del pedido
		// completo, para que el usuario lo confirme
		String respuesta = "";
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

		servicioPedidos.procesarPaso2(titular, numero, usuario);
		
		ResumenPedido resumen = servicioPedidos.obtenerResumenDelPedido(usuario);
		
		respuesta = "ok:" + new Gson().toJson(resumen);
		
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);

	}// end paso 1
	
	@RequestMapping("confirmarPedido")
	public ResponseEntity<String> confirmarPedido(HttpServletRequest request) {
		String respuesta = "";
		servicioPedidos.confirmarPedido((Usuario)request.getSession().getAttribute("usuario"));
		
		respuesta = "Pedido completado, puedes seguir comprando :)";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
}
