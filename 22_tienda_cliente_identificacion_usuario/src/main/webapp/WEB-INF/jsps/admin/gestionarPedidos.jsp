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

listado de pedidos: <br>

<c:forEach var="pedido" items="${pedidos}">
	<div style="margin: 20px">
		${pedido.nombreCompleto} <br>
		${pedido.direccion} <br>
		estado: ${pedido.estado} <br>
		<a href="verDetallesPedido?id=${pedido.id}">ver pedido</a>
	</div>
</c:forEach>


</body>
</html>