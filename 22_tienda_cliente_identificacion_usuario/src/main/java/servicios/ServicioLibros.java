package servicios;

import java.util.List;

import modelo.Libro;

public interface ServicioLibros {

	
	public void registrarLibro(Libro l);
	
	public int obtenerTotalDeLibros(String titulo);
	
	public List<Libro> obtenerLibros(String titulo, int comienzo);
	
	public Libro obtenerLibroPorId(int id);
	
	public void borrarLibro(int id);

	public void guardarCambiosLibro(Libro l);
	
}
