package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {

	void registrarUsuario(Usuario u);
	
	List<Usuario> obtenerUsuarios();
	
	void borrarUsuario(int id);

	Usuario obtenerUsuarioPorId(int idUsuario);
	
	void guardarCambiosUsuario(Usuario u);
	
	Usuario obtenerUsuarioPorEmailYPass(String email, String pass);

}
