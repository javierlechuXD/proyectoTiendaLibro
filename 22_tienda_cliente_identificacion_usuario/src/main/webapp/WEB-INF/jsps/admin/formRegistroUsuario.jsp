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

inserta tus datos:
<springform:form modelAttribute="usuario" action="guardarNuevoUsuario">

	nombre: <springform:input path="nombre"/> <br>
	email: <springform:input a="f" type="email" path="email"/> <br>	
	pass: <springform:input path="pass"/> <br>	
	
	<input type="submit" value="REGISTRARME" />

</springform:form>


</body>
</html>