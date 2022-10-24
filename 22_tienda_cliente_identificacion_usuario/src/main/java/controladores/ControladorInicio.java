package controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Versión: 24_tienda_carrito
@Controller
public class ControladorInicio {

	@RequestMapping("/inicio")
	public String inicio() {
		return "inicio";
	}
	
}
