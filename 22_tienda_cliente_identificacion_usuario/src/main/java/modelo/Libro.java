package modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Libro {

	private String titulo;
	private String descripcion;
	private double precio;
	private boolean alta;
	
	@Column(nullable = true)
	private Date fechaImagenPortada1;
	
	// Vamos a indicar que uno o más libros estén asociados a una categoría
	// Con optional false indica que idLibro no puede ser nulo//
	@ManyToOne(targetEntity = Categoria.class, optional = false, fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@Transient
	private int idCategoria;
	
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
	
	

	public Libro(String titulo, double precio, boolean alta, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.alta = alta;
		this.categoria = categoria;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Date getFechaImagenPortada1() {
		return fechaImagenPortada1;
	}

	public void setFechaImagenPortada1(Date fechaImagenPortada1) {
		this.fechaImagenPortada1 = fechaImagenPortada1;
	}


	
}
