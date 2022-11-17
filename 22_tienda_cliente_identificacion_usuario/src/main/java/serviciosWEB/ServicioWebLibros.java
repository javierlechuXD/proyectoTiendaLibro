package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import servicios.ServicioLibros;

@Controller
@RequestMapping("ServicioWebLibros/")
public class ServicioWebLibros {

	@Autowired
	private ServicioLibros servicioLibros;
	
	@RequestMapping("obtenerLibros")
	public ResponseEntity<String> obtenerLibros(@RequestParam(defaultValue = "") String titulo){
		
		String respuesta = new Gson().toJson(servicioLibros.obtenerLibros(titulo,0));
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
		
	}
	
	@RequestMapping("obtenerLibroPorId")
	public ResponseEntity<String> obtenerLibroPorId(String id){
		String json = 
			new Gson().toJson(servicioLibros.obtenerLibroPorId(Integer.parseInt(id)));
		return new ResponseEntity<String>(json,HttpStatus.OK);		
	}
	
}//end class




