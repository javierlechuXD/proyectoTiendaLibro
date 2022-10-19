package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import modelo.Libro;

public class GestorArchivos {

	public static void guardarPortadaLibro(Libro l, String rutaReal) {
		String nombreArchivo = l.getId() + ".jpg";
		String rutaSubidas = rutaReal + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(l.getPortada().getSize() > 0) {
			try {
				l.getPortada().transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("se subio un libro sin portada, no hay problema,"
					+ "de momento la imagen es opcional");
		}
		
		
	}
	
}
