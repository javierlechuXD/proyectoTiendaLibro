package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.Paginacion;
import modelo.Categoria;
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
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class, l.getIdCategoria());
		l.setCategoria(c);;
		
		sessionFactory.getCurrentSession().save(l);
		//hibernate una vez ha registrado un objeto
		//le asigna al mismo la id generada
	}

	@Override
	public List<Libro> obtenerLibros(String titulo, int comienzo) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Libro.class);
		c.add(Restrictions.like("titulo", "%"+titulo+"%"));
		c.addOrder(Order.desc("id"));
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADOS_POR_PAGINA);
		return c.list();
	}

	@Override
	public void borrarLibro(int id) {
		Libro l = (Libro)sessionFactory.getCurrentSession().get(Libro.class,id);
		sessionFactory.getCurrentSession().delete(l);
	}

	@Override
	public Libro obtenerLibroPorId(int id) {
		return (Libro)sessionFactory.getCurrentSession().get(Libro.class, id);
	}

	@Override
	public void guardarCambiosLibro(Libro l) {
		System.out.println("Editando libro con id:" + l.getId());
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class, l.getIdCategoria());
		l.setCategoria(c);
		sessionFactory.getCurrentSession().merge(l);
	}
	
	
	
}
