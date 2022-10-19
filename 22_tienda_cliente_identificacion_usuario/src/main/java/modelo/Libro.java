package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Libro {

	private String titulo;
	private double precio;
	private boolean alta;
	
	@Transient //con @Transient, el siguiente campo es ignorado por hibernate
	private MultipartFile portada;
	
	@Id
	@GeneratedValue
	private int id;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	
	public Libro(String titulo, double precio, int id) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	
	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
