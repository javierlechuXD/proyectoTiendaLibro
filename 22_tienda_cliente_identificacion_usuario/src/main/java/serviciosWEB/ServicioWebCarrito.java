package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import servicios.ServicioCarrito;

@Controller
@RequestMapping("ServicioWebCarrito/")
public class ServicioWebCarrito {
	
	@Autowired
	private ServicioCarrito servicioCarrito;
	
	@RequestMapping("agregarLibro")
	public ResponseEntity<String> agregarLibro(String idProducto, String cantidad, HttpServletRequest request){
		String respuesta= "agregar el producto de id: " + idProducto + "Cantidad: " +
				cantidad + " al carrito del usuario: " + 
				((Usuario)request.getSession().getAttribute("usuario")).getNombre();
		servicioCarrito.agregarProducto((Usuario)request.getSession().getAttribute("usuario"), Integer.parseInt(idProducto), Integer.parseInt(cantidad));
		respuesta = "Agregado correctamente";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
				
	}

}




