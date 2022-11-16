package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modelo.Libro;
import modelo.Usuario;

public class GestorArchivos {
	
	public static boolean borrarPortadaLibro(String idLibro, String rutalReal) {
		File f = new File(rutalReal+"/subidas/"+idLibro+".jpg");
		if(f.delete()) {
			System.out.println("Archivo borrado correctamente");
			return true;
		}else {
			System.out.println("No se pudo borrar el archivo");
			return false;
		}
	}

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

	public static void guardarFotoUsuario(Usuario u, CommonsMultipartFile foto, String rutaRealDelProyecto) {
		String nombreArchivo = "u" + u.getId() + ".jpg";
		String rutaSubidas = rutaRealDelProyecto + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(foto.getSize() > 0) {
			try {
				foto.transferTo(new File(rutaSubidas,nombreArchivo));
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
