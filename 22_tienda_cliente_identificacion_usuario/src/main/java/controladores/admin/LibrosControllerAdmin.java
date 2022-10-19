package controladores.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Libro;
import servicios.ServicioCategorias;
import servicios.ServicioLibros;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("admin/")
public class LibrosControllerAdmin {

	@Autowired
	private ServicioLibros servicioLibros;
	
	@Autowired ServicioCategorias servicioCategorias;
	
	@RequestMapping("gestionarLibros")
	public String gestionarLibros(Model model) {
		model.addAttribute("libros",servicioLibros.obtenerLibros());
		return "admin/gestionarLibros";
	}
	
	@RequestMapping("nuevoLibro")
	public String nuevoLibro(Model model) {
		Libro libro = new Libro();
		libro.setAlta(true);
		model.addAttribute("nuevoLibro",libro);
		// Pedir las categorías para darselas a formRegistroLibro
		
		// El tipo de dato idea en java para desplegables es el tipo Map
		// donde cada elemento tiene un elemento y un valor
		model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formRegistroLibro";
	}
	
	@RequestMapping("guardarNuevoLibro")
	public String guardarNuevoLibro(Libro nuevoLibro, Model model, HttpServletRequest request ) {

		servicioLibros.registrarLibro(nuevoLibro);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");

		
		GestorArchivos.guardarPortadaLibro(nuevoLibro, rutaRealDelProyecto);
		return gestionarLibros(model);
		
	}
	
	
}










