package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		respuesta = "ok, paso 2 por hacer";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
}
