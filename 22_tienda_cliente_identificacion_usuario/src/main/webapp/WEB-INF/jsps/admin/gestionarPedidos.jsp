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

Listado de Pedidos: <br>

<c:forEach var="pedido" items="${pedidos}">
	<div style="margin: 20px">
		Nombre Completo: ${pedido.nombreCompleto}<br>
		Dirección: ${pedido.direccion}<br>
		Estado: ${pedido.estado}<br>
		<a href="verDetallesPedido?id=${pedido.id}" >Ver Pedido</a>
	</div>
</c:forEach>


</body>
</html>