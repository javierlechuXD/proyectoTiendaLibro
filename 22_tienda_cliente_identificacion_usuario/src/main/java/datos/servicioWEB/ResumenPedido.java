package datos.servicioWEB;

import java.util.List;
import java.util.Map;

//respuesta desde ServicioWEBPedidos
//indicando el resumen del pedido realizado por el usuario
public class ResumenPedido {

	private List<Map<String, Object>> libros;
	
	//paso1	
	private String nombreCompleto;
	private String direccion;
	private String provincia;
	
	//paso2
	private String titularTarjeta;
	private String numeroTarjeta;
	
	public List<Map<String, Object>> getLibros() {
		return libros;
	}
	public void setLibros(List<Map<String, Object>> libros) {
		this.libros = libros;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTitularTarjeta() {
		return titularTarjeta;
	}
	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
}
