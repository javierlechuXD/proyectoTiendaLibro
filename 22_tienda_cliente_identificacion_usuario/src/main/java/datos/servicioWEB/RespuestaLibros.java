package datos.servicioWEB;

import java.util.List;

import modelo.Libro;

public class RespuestaLibros {
	
	private int total;
	private List<Libro> libros;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
}
