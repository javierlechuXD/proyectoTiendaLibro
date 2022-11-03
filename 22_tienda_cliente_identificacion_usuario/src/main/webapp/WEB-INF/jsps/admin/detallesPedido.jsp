<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div style="text-align: center;">
		Detalles del pedido
	</div>
	
	Nombre: ${pedido.nombreCompleto}<br>
	Dirección: ${pedido.direccion}<br>
	Provincia: ${pedido.provincia}<br>
	<br>
	Titular Tarjeta: ${pedido.titularTarjeta}<br>
	Número de Tarjeta: ${pedido.numeroTarjeta}<br>
	
	<div style="text-align: center;">
		Productos del Pedido
	</div>
	
	<c:forEach var="pp" items="${pedido.productosPedido}">
		<div style="margin: 20px">
			Titulo: ${pp.libro.titulo}<br>
			Precio/u: ${pp.libro.precio}<br>
			Cantidad: ${pp.cantidad}<br>
			
		</div>
	</c:forEach>
	
	<div style="margin: 10px">
		Estado del pedido: <br>
		<select id="select_estado">
			<c:forEach var="estado" items="${estados}">
				<option 
					<c:if test="${estado.key == pedido.estado}">
						select="selected"
					</c:if>				
					value="${estado.key}"> ${estado.value} </option>
			</c:forEach>

		</select>
	</div>
	
<input type="hidden" id="id_pedido" value="${pedido.id}">
	
<script type="text/javascript" src="../librerias_js/jquery.js"></script>
<script type="text/javascript">
	$("#select_estado").change(function(e) {
		//obtener el estado seleccionado y mandarlo a un servicio web
		let estado = $(this).find(":selected").val();
		let idPedido = $("#id_pedido").val();
		$.post("ServicioWebPedidosAdmin/actualizarEstadoPedido", 
				{
					id: idPedido,
					estado: estado
				}
		).done(function(res) {
			alert(res);
		});
	});
</script>

</body>
</html>