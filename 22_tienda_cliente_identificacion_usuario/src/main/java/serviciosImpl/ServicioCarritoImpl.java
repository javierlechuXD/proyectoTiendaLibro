package serviciosImpl;

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
public class ServicioCarritoImpl implements ServicioCarrito{
	
	//una alternativa a @Autowired es @Resource que hace basicamente lo mismo
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void agregarProducto(Usuario u, int idProducto, int cantidad) {
		//obtener el carrito del usuario o crearlo si no existe
		//primero obtener el usuario de base de datos, dicha informacion
		//difiere del usuario recibido como parametro que es el guardado
		//en sesion
		Usuario uBaseDeDatos = 
				(Usuario)sessionFactory.getCurrentSession().
					get(Usuario.class, u.getId());
		Carrito c = uBaseDeDatos.getCarrito();
		if( c == null ) {
			c = new Carrito();
			c.setUsuario(uBaseDeDatos);
			uBaseDeDatos.setCarrito(c);
			sessionFactory.getCurrentSession().save(c);
		}
		//una vez obtenido o creado el carrito
		//vamos a ver si el producto que se quiere agregar ya existe en el carrito
		boolean producto_en_carrito = false;
		for(ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
			if (pc_en_carrito.getLibro().getId() == idProducto) {
				producto_en_carrito = true;
				pc_en_carrito.setCantidad( pc_en_carrito.getCantidad()+cantidad);
				sessionFactory.getCurrentSession().merge(pc_en_carrito);
			}
		}
		//si el producto no esta en el carrito
		if( ! producto_en_carrito) {
			ProductoCarrito pc = new ProductoCarrito();
			pc.setCarrito(c);
			pc.setCantidad(cantidad);
			pc.setLibro(
					(Libro)sessionFactory.getCurrentSession().
						get(Libro.class, idProducto)
						);
			sessionFactory.getCurrentSession().save(pc);
		}
		
	}//end agregar producto

	@Override
	public List<Map<String, Object>> obtenerProductoCarrito(Usuario u) {
		Usuario uBaseDatos = (Usuario)
				sessionFactory.getCurrentSession().
					get(Usuario.class, u.getId());
		Carrito c = uBaseDatos.getCarrito();
		List<Map<String, Object>> res = null;
		if(c != null) {
			SQLQuery query = sessionFactory.getCurrentSession().
					createSQLQuery(ConstantesSQL.SQL_OBTENER_PRODUCTOS_CARRITO);
			query.setParameter("carrito_id", c.getId());
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);	
			res = query.list();
		}
		
		return res;
	}
	
}//en class




