<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
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

datos del usuario a editar:

<springform:form modelAttribute="usuario" action="actualizarUsuario">

	nombre: <springform:input path="nombre"/> <br>
	email: <springform:input type="email" path="email"/> <br>	
	pass: <springform:input path="pass"/> <br>	
	
	<springform:hidden path="id"/>
	
	<input type="submit" value="GUARDAR CAMBIOS" />

</springform:form>


</body>
</html>