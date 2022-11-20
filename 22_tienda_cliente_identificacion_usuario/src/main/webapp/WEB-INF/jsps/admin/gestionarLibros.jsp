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

<div style="margin: 10px">
	<form action="gestionarLibros">
		titulo: <input type="text" name="titulo" value="${titulo}" />
		<input type="submit" value="BUSCAR">
	</form>
</div>


<div style="text-align: center;">
	paginacion: <br>
	total de libros: ${total} <br>
	
	<c:if test="${ anterior >= 0 }">
			<a href="gestionarLibros?comienzo=${anterior}&titulo=${titulo}">anterior</a>	
	</c:if>

	&nbsp;&nbsp;&nbsp;&nbsp;

	<c:if test="${ siguiente < total }">
			<a href="gestionarLibros?comienzo=${siguiente}&titulo=${titulo}">siguiente</a>
	</c:if>


</div>


<c:forEach var="libro" items="${libros}">
	<div style="margin: 10px">
		portada: <br>
		<object style="height: 60px" data="../subidas/${libro.id}.jpg?fai=${libro.fechaImagenPortada}">
			<img style="height: 60px" src="../subidas/libro.jpg"/>		
		</object>
		
		<br>
		titulo: ${libro.titulo} <br>
		alta: ${libro.alta} <br>
		precio: ${libro.precio} <br>
		categoria: ${libro.categoria.nombre} <br>
		<a onclick="return confirm('¿seguro?');" href="borrarLibro?idBorrar=${libro.id}">
			borrar
		</a>&nbsp;
		<a href="editarLibro?idEditar=${libro.id}">
			editar
		</a>&nbsp;
		<a 
		href="agregarIdioma?idLibro=${libro.id}"
		onclick="alert('mostrar formulario para registrar para el libro textos en otro idioma'); return false;">
			agregar textos en otro idioma
		</a>
			
	</div>
</c:forEach>

</body>
</html>