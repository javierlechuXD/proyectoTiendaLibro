package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;

@Controller
@RequestMapping("ServicioWebCarrito/")
public class ServicioWebCarrito {
	
	@RequestMapping("agregarLibro")
	public ResponseEntity<String> agregarLibro(String idProducto, HttpServletRequest request){
		String respuesta= "agregar el producto de id: " + idProducto + 
				" al carrito del usuario: " + 
				((Usuario)request.getSession().getAttribute("usuario")).getNombre();
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
				
	}

}




