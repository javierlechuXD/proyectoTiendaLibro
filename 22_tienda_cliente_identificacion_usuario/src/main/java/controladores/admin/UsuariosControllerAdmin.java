package controladores.admin;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Controller
@RequestMapping("/admin/")
public class UsuariosControllerAdmin {
	
	//autowired asigna automaticamente una bean 
	//del mismo tipo indicado del contenedor de spring

	//autowired en este caso pide la bean cuya
	//clase implemente ServicioUsuarios
	//dicha bean es la que hemos cargado en beans.xml
	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@RequestMapping("gestionarUsuarios")
	public String gestionarUsuarios(Model model) {
		//pedir los usuarios al dao y meterlos en model
		//para que le lleguen a la jsp
		model.addAttribute("usuarios",servicioUsuarios.obtenerUsuarios());		
		return "admin/gestionarUsuarios";
	}
	
	@RequestMapping("borrarUsuario")
	public String borrarUsuario(String idBorrar, Model model) {
		servicioUsuarios.borrarUsuario(Integer.parseInt(idBorrar));
		return gestionarUsuarios(model);
	}
	
	@RequestMapping("nuevoUsuario")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/formRegistroUsuario";
	}
	
	@RequestMapping("guardarNuevoUsuario")
	public String guardarNuevoUsuario(Usuario usuario, Model model) {
		servicioUsuarios.registrarUsuario(usuario);
		return gestionarUsuarios(model);		
	}
	
	@RequestMapping("editarUsuario")
	public String editarUsuario(String idEditar, Model model) {
		Usuario usuario = 
				servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idEditar));
		model.addAttribute("usuario", usuario);
		return "admin/formEditarUsuario";
	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario(Usuario usuario, Model model) {
		servicioUsuarios.guardarCambiosUsuario(usuario);
		return gestionarUsuarios(model);
	}
	
}





