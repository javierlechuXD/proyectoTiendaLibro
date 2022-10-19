package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categoria {
	
	private String nombre;
	private String descripcion;
	
	@Id
	@GeneratedValue
	private int id;
	

}
