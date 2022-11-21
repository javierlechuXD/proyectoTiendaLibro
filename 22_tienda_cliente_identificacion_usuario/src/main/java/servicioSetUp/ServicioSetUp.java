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

// utilidad para preparar registros

@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setUp() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(SetUp.class);
		
		if (c.list().size() == 0) {
			//preparamos unos registros
			
			sessionFactory.getCurrentSession().save(new Usuario("ares", "123", "ares@gmail.com"));
			
			sessionFactory.getCurrentSession().save(new Usuario("javi", "123", "javi@gmail.com"));
			
			sessionFactory.getCurrentSession().save(new Usuario("lechu", "123", "lechu@gmail.com"));
			
			Categoria novela = new Categoria("novela", "categoría novela clásica");
			sessionFactory.getCurrentSession().save(novela);
			
			Categoria aventura = new Categoria("aventura", "categoría aventura clásica");
			sessionFactory.getCurrentSession().save(aventura);
			
			Categoria terror = new Categoria("terror", "categoría terror clásica");
			sessionFactory.getCurrentSession().save(terror);
			

			
			String titulo = "100 Años de soledad";
			String descripcion = "Descripción por defecto";
			for (int i = 0; i < 100; i++) {
				String tituloGuardar = titulo + i;
				String descripcionGuardar = descripcion + i;
				sessionFactory.getCurrentSession().save(new Libro(tituloGuardar, descripcionGuardar, 33.5, true, novela));
			}
			
			sessionFactory.getCurrentSession().save(new Libro("El quijote","Descripción por defecto", 10.5, true, terror));
			sessionFactory.getCurrentSession().save(new Libro("Salmón","Descripción por defecto", 13.5, true, aventura));
			sessionFactory.getCurrentSession().save(new Libro("Lechu Valiente","Descripción por defecto", 12.5, true, novela));
			
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
		}
	}
}
