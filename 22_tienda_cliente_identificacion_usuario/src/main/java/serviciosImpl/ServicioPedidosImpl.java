package serviciosImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import modelo.Pedido;
import modelo.Usuario;
import servicios.ServicioPedidos;

@Service
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void procesarPaso1(String nombreCompleto, String direccion, String provincia, Usuario usuario) {
		
		Pedido p = new Pedido();
		p.setUsuario(usuario);
		p.setEstado("en proceso"); // Mas adelante solo podrá haber un pedido en proceso para un mismo usuario
		p.setNombreCompleto(nombreCompleto);
		p.setDireccion(direccion);
		p.setProvincia(provincia);
		
		sessionFactory.getCurrentSession().save(p);
	}

}
