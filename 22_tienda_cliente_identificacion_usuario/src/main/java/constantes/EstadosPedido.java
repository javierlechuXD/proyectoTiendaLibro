package constantes;

//estas constantes definen los posibles estados 
//de un pedido
public class EstadosPedido {
	
	//el usuario ha iniciado el procesar pedido
	public static final String EN_PROCESO = "en proceso";
	
	//el usuario ha completado un pedido
	public static final String COMPLETADO = "completado";
	
	//un administrador ha preparado el envio del pedido
	public static final String LISTO_PARA_ENVIAR = 
			"listado para enviar";
	
	//el pedido se ha enviado
	public static final String ENVIADO = "enviado";
	
}
