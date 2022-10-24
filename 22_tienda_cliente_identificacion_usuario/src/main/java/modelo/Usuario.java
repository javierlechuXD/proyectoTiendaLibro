package modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	private String nombre;
	private String pass;
	private String email;
	 
	@OneToOne
	private Carrito carrito;
	
	@Id
	@GeneratedValue
	private int id;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String pass, String email) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
	}



	public Usuario(String nombre, String pass, String email, int id) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", email=" + email + ", id=" + id + "]";
	}
	
}
