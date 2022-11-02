package constantes;


// Definición de los posibles estados de un pedido
public class EstadosPedido {

	// El usuario ha iniciado el procesar pedido - completado paso 1
	public static final String EN_PROCESO = "en proceso";
	
	// El usuario ha completado un pedido
	public static final String COMPLETADO = "completado";
	
	// Un administrador ha preparado el envio del pedido
	public static final String LISTO_PARA_ENVIAR = "listado para enviar";
	
	// El pedido se ha enviado
	public static final String ENVIADO = "enviado";


}
