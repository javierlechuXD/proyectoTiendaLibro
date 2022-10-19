package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categoria {
	
	
	private String nombre;
	@Column(name = "descripcion_categoria", length = 9000)
	private String descripcion;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Libro> libros = new ArrayList<Libro>();
	
	@Id
	@GeneratedValue
	private int id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

//	public List<Libro> getLibros() {
//		return libros;
//	}
//
//	public void setLibros(List<Libro> libros) {
//		this.libros = libros;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
