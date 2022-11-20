<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	<div style="text-align: center;">detalles del pedido:</div>
	nombre: ${pedido.nombreCompleto} <br>
	direccion: ${pedido.direccion} <br>
	provincia: ${pedido.provincia} <br>
	<br>
	titular tarjeta: ${pedido.titularTarjeta} <br>
	numero de tarjeta: ${pedido.numeroTarjeta} <br>
	
	<div style="text-align: center">productos del pedido:</div>
	<c:forEach var="pp" items="${pedido.productosPedido}">
		<div style="margin: 20px">
			titulo: ${pp.libro.titulo}<br>
			precio/unidad: ${pp.libro.precio}<br>
			cantidad: ${pp.cantidad}<br>
		</div>
	</c:forEach>
	
	<div style="margin: 10px">
		ESTADO DEL PEDIDO:<br>
		<select id="select_estado">
			<c:forEach var="estado" items="${estados}">
				<option 
				
					<c:if test="${ estado.key == pedido.estado }">
						selected
					</c:if>
				
					value="${estado.key}"
				> ${estado.value} </option>
			</c:forEach>
		</select>
	</div>
	
<input type="hidden" id="id_pedido" value="${pedido.id}"/>
	
<script type="text/javascript" src="../librerias_js/jquery.js" ></script>
<script type="text/javascript">
	$("#select_estado").change(function(e){
		//obtener el estado seleccionado y mandarlo a un servicio web
		let estado = $(this).find(":selected").val();
		let idPedido = $("#id_pedido").val();
		$.post("ServicioWebPedidosAdmin/actualizarEstadoPedido",
				{
					id: idPedido,
					estado : estado
				}
		).done(function(res){
			alert(res);
		});
	});//end change
</script>

</body>
</html>




