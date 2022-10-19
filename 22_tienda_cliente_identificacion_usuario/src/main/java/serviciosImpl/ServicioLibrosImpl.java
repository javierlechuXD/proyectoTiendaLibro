package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Libro;
import servicios.ServicioLibros;

//implementacion de las operaciones con libros
//usando hibernate

@Service
@Transactional
public class ServicioLibrosImpl implements ServicioLibros{

	//todas las operaciones con hibernate
	//se haran a traves del siguiente elemento
	
	//el siguiente elemento es la bean 
	//sessionFactory definida en datasource.xml
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarLibro(Libro l) {
		sessionFactory.getCurrentSession().save(l);
		//hibernate una vez ha registrado un objeto
		//le asigna al mismo la id generada
	}

	@Override
	public List<Libro> obtenerLibros() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Libro.class);
		c.addOrder(Order.desc("id"));
		return c.list();
	}

	@Override
	public void borrarLibro(int id) {
		Libro l = (Libro)sessionFactory.getCurrentSession().get(Libro.class,id);
		sessionFactory.getCurrentSession().delete(l);
	}

	@Override
	public void editarLibro(Libro l, int id) {
		//en un futuro no pediremos la id
		sessionFactory.getCurrentSession().merge(l);
	}

	@Override
	public Libro obtenerLibroPorId(int id) {
		return (Libro)sessionFactory.getCurrentSession().get(Libro.class, id);
	}
	
	
}