package servicios;

import java.util.List;

import modelo.Libro;

public interface ServicioLibros {

	
	public void registrarLibro(Libro l);
	
	public List<Libro> obtenerLibros();
	
	public Libro obtenerLibroPorId(int id);
	
	public void borrarLibro(int id);
	
	public void editarLibro(Libro l, int id);
	
}
