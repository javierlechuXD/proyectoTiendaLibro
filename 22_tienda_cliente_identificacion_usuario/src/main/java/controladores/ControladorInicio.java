package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import servicioSetUp.InterfazSetUp;
import servicioSetUp.ServicioSetUp;
import servicios.ServicioCarrito;

// Versión: 24_tienda_carrito
@Controller
public class ControladorInicio {

	@Autowired
	private InterfazSetUp servicioSetUp;
	
	@RequestMapping("/inicio")
	public String inicio() {
		servicioSetUp.setUp();
		return "inicio";
	}
	
}
