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

<div style="margin: 10px">
	<a href="nuevoUsuario">registrar un usuario</a>	
</div>

gestion de usuarios: <br>

<c:forEach var="usuario" items="${usuarios}" >
	<div>
		nombre: ${usuario.nombre} email: ${usuario.email} 
		<a onclick="return confirm('�seguro?');" href="borrarUsuario?idBorrar=${usuario.id}">
			borrar
		</a>&nbsp;
		<a href="editarUsuario?idEditar=${usuario.id}">
			editar
		</a>		
	</div>
</c:forEach>


</body>
</html>