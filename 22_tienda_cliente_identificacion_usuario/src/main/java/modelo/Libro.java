package modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Libro {

	@NotEmpty
	@Size(min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String titulo;
	
	@NotEmpty(message = "Descripción no puede estar vacio")
	@Size(min = 1, max = 2000, message = "Descripción debe tener entre 1 y 2000 caracterec")
	@Pattern(regexp = "^[a-zA-Z ().,áéíóúÁÉÍÓÚñÑ0-9]{1,2000}$", message = "Solo letras, números, puntos, comas y paréntesis")
	private String descripcion;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,###.###")
	@Min(value = 1, message = "El precio mímimo es de un euro")
	@Max(value = 9999, message = "El precio máximo es de 9999")
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
	
	public Libro(String titulo, String descripcion, double precio, boolean alta, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
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
