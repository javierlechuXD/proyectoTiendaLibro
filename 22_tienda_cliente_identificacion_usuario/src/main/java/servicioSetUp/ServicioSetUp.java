package servicioSetUp;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import modelo.Libro;
import modelo.SetUp;
import modelo.Usuario;

//utilidad para preparar unos registros

@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setUp() {
		Criteria c = 
				sessionFactory.getCurrentSession().
					createCriteria(SetUp.class);
		if ( c.list().size() == 0 ) {
			//preparamos unos registros
			sessionFactory.getCurrentSession().save( 
					new Usuario("ares", "123", "ares@gmail.com") 
				);
			sessionFactory.getCurrentSession().save( 
					new Usuario("pepe", "123", "pepe@gmail.com") 
				);
			sessionFactory.getCurrentSession().save( 
					new Usuario("juan", "123", "juan@gmail.com") 
				);
			//categorias
			Categoria novela = new Categoria("novela","categoria novela clasica");
			sessionFactory.getCurrentSession().save(
					novela
					);
			Categoria cienciaFiccion = new Categoria("ciencia ficcion","categoria ciencia ficcion");
			sessionFactory.getCurrentSession().save(
					cienciaFiccion
					);
			sessionFactory.getCurrentSession().save(
					new Categoria("aventura","categoria aventura")
					);
			//libros
			//registrar 100 un libro de prueba para ver paginacion:
			String titulo = "100 Años de soledad ";
			for (int i = 0; i < 100; i++) {
				String tituloAguardar = titulo + i;
				sessionFactory.getCurrentSession().save(
						new Libro(tituloAguardar, 10, true, novela)
						);
			}
			
			sessionFactory.getCurrentSession().save(
					new Libro("El Quijote", 10.5, true, novela)
					);
			sessionFactory.getCurrentSession().save(
					new Libro("La Celestina", 7.5, true, novela)
					);
			sessionFactory.getCurrentSession().save(
					new Libro("Jurassic Park", 7, true, cienciaFiccion)
					);
			
			//copiar archivos de portada de libros
			//desde una ruta fija
			
			//setup completado
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
			
		} //end if
		
	}//end setUp
	
}







