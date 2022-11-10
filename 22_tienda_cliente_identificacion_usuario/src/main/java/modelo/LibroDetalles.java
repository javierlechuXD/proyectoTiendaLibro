package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LibroDetalles {
	
	private String idioma;
	private String titulo;
	private String descripcion;
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Libro libro;
	
	
	
}
