package serviciosImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesSQL;
import modelo.Carrito;
import modelo.Libro;
import modelo.ProductoCarrito;
import modelo.Usuario;
import servicios.ServicioCarrito;

@Service
@Transactional
public class ServicioCarritoImpl implements ServicioCarrito {

	//Una alternatica a @Autowired es @Resource
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarProducto(Usuario u, int idProducto, int cantidad) {
		// Obtener el carrito del usuario o crearlo si no existe
		
		//Primero obtener usuario BD, dichos datos difieren del
		//usuario recibido como parámetro que es el guardado en sesión
		
		Usuario uBaseDeDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId());
		
		Carrito c = uBaseDeDatos.getCarrito();
		if(c == null) {
			c = new Carrito();
			c.setUsuario(uBaseDeDatos);
			uBaseDeDatos.setCarrito(c);
			sessionFactory.getCurrentSession().save(c);
		}
		//Una vez obtenido o creado el carrito
		//Vamos a ver si el producto que se quiere agregar ya existe en el carrito
		boolean producto_en_carrito = false;
		
		for(ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
			if (pc_en_carrito.getLibro().getId() == idProducto) {
				producto_en_carrito = true;
				pc_en_carrito.setCantidad(pc_en_carrito.getCantidad()+cantidad);
				sessionFactory.getCurrentSession().merge(pc_en_carrito);
			}
		}
		
		if(!producto_en_carrito) {
			ProductoCarrito pc = new ProductoCarrito();
			pc.setCarrito(c);
			pc.setCantidad(cantidad);
			pc.setLibro((Libro)sessionFactory.getCurrentSession().get(Libro.class, idProducto));
			sessionFactory.getCurrentSession().save(pc);
		}
	}

	@Override
	public List<Map<String, Object>> obtenerProductosCarrito(Usuario usuario) {
		Usuario uBaseDeDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		
		Carrito c = uBaseDeDatos.getCarrito();
		
		List<Map<String, Object>> res = null;
		if (c != null) {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.SQL_OBTENER_PRODUCTOS_CARRITO);
			query.setParameter("carrito_id", c.getId());
			
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			res = query.list();
		}
		return res;
	}

}
