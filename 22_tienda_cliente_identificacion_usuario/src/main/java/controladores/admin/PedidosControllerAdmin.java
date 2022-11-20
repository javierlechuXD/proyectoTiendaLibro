package controladores.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import constantes.EstadosPedido;
import modelo.Pedido;
import servicios.ServicioPedidos;

@Controller
@RequestMapping("admin/")
public class PedidosControllerAdmin {

	@Autowired
	private ServicioPedidos servicioPedidos;
	
	@RequestMapping("gestionarPedidos")
	public String gestionarPedidos(Model model) {
		model.addAttribute("pedidos",servicioPedidos.obtenerPedidos());
		return "admin/gestionarPedidos";
	}
	
	@RequestMapping("verDetallesPedido")
	public String verDetallesPedido(String id, Model model) {
		Pedido p = servicioPedidos.obtenerPedidoPorId(Integer.parseInt(id));
		model.addAttribute("pedido",p);
		
		Map<String, String> estados = new HashMap<String,String>();
		estados.put(EstadosPedido.COMPLETADO, "completado por el usuario");
		estados.put(EstadosPedido.LISTO_PARA_ENVIAR, "listo para enviar");
		estados.put(EstadosPedido.ENVIADO, "enviado");
		model.addAttribute("estados",estados);
		
		return "admin/detallesPedido";
	}
	
}







