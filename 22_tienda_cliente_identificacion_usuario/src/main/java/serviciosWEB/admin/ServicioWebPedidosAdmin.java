package serviciosWEB.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import servicios.ServicioPedidos;

@Controller
@RequestMapping("admin/ServicioWebPedidosAdmin/")
public class ServicioWebPedidosAdmin {
	
	@Autowired
	private ServicioPedidos servicioPedidos;
	
	@RequestMapping("actualizarEstadoPedido")
	public ResponseEntity<String> actualizarEstadoPedido(String id, String estado){
		String respuesta= "";
		servicioPedidos.actualizarEstadoPedido(Integer.parseInt(id), estado);
		respuesta = "estado actualizado correctamente";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);	
	}//end agregarLibro

}






