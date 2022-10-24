package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductoCarrito {
	
	//Muchos a uno (Es una forma de coger la clave foránea)
	@ManyToOne
	private Carrito carrito;
	
	@ManyToOne
	private Libro libro;
	
	private int cantidad;
	
	
	@Id
	@GeneratedValue
	private int id;


	public Carrito getCarrito() {
		return carrito;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
