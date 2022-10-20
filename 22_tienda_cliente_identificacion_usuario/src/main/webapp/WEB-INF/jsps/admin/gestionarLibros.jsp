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

<div style="margin: 15px">
	<a href="nuevoLibro">registrar un libro</a>	
</div>

<c:forEach var="libro" items="${libros}">
	<div style="margin: 10px">
		portada: <br>
		<img style="height: 60px" src="../subidas/${libro.id}.jpg"/>
		<br>
		titulo: ${libro.titulo} <br>
		alta: ${libro.alta} <br>
		precio: ${libro.precio} <br>
		categoría: ${libro.categoria.nombre}
		<a onclick="return confirm('¿seguro?');" href="borrarLibro?idBorrar=${libro.id}">
			borrar
		</a>&nbsp;
		<a href="editarLibro?idEditar=${libro.id}">
			editar
		</a>		
	</div>
</c:forEach>

</body>
</html>