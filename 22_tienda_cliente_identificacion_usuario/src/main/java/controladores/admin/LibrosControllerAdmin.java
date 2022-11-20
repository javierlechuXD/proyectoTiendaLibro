package controladores.admin;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constantes.Paginacion;
import modelo.Libro;
import servicios.ServicioCategorias;
import servicios.ServicioLibros;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("admin/")
public class LibrosControllerAdmin {

	@Autowired
	private ServicioLibros servicioLibros;
	
	@Autowired
	private ServicioCategorias servicioCategorias;
	
	@RequestMapping("gestionarLibros")
	public String gestionarLibros(Model model, @RequestParam(defaultValue = "") String titulo,  @RequestParam(defaultValue = "0" ) String comienzo) {
		
		int comienzo_int = Integer.parseInt(comienzo);
		
		System.out.println("mostrar resultados desde: " + comienzo_int);
		
		model.addAttribute("libros",servicioLibros.obtenerLibros(titulo,comienzo_int));
		model.addAttribute("titulo",titulo);
		model.addAttribute("siguiente", 
				comienzo_int + Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("anterior",
				comienzo_int - Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("total",servicioLibros.obtenerTotalDeLibros(titulo));
		return "admin/gestionarLibros";
	}
	
	@RequestMapping("nuevoLibro")
	public String nuevoLibro(Model model) {
		Libro libro = new Libro();
		libro.setAlta(true);
		model.addAttribute("nuevoLibro",libro);
		//pedir las categorias para darselas a formRegistroLibro
		
		//el tipo de dato ideal en java para desplegables es el tipo Map
		//donde cada elemento tiene un nombre y un valor
		model.addAttribute("categorias", 
				servicioCategorias.obtenerCategoriasParaDesplegable());
		
		
		return "admin/formRegistroLibro";
	}
	
	@RequestMapping("guardarNuevoLibro")
	public String guardarNuevoLibro(Libro nuevoLibro, Model model, HttpServletRequest request ) {

		if(nuevoLibro.getPortada().getSize() != 0) {
			nuevoLibro.setFechaImagenPortada(new Date());
		}
		servicioLibros.registrarLibro(nuevoLibro);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");		
		GestorArchivos.guardarPortadaLibro(nuevoLibro, rutaRealDelProyecto);
		return gestionarLibros(model,"","0");
		
	}
	
	//el nombre del parametro del metodo idBorrar
	//debe ser identico al del enlace borrar
	@RequestMapping("borrarLibro")
	public String borrarLibro(String idBorrar, 
			HttpServletRequest request, Model model) {
		servicioLibros.borrarLibro(Integer.parseInt(idBorrar));
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");
		GestorArchivos.borrarPortadaLibro(idBorrar, rutaRealDelProyecto);
		return gestionarLibros(model,"","0");
	}
	
	@RequestMapping("editarLibro")
	public String editarLibro(String idEditar, Model model) {
		Libro l = servicioLibros.obtenerLibroPorId(Integer.parseInt(idEditar));
		Map<String, String> mapCategorias = 
				servicioCategorias.obtenerCategoriasParaDesplegable();
		l.setIdCategoria(l.getCategoria().getId());
		model.addAttribute("libro",l);
		model.addAttribute("categorias",mapCategorias);
		return "admin/formEditarLibro";		
	}
	
	@RequestMapping("guardarCambiosLibro")
	public String guardarCambiosLibro(Libro libro,Model model, HttpServletRequest request) {
		if(libro.getPortada().getSize() != 0) {
			libro.setFechaImagenPortada(new Date());
		}		
		servicioLibros.guardarCambiosLibro(libro);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");		
		GestorArchivos.guardarPortadaLibro(libro, rutaRealDelProyecto);
		return gestionarLibros(model,"","0");
	}
	
}










