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

inserta los datos del nuevo libro:
<!-- 
con enctype="multipart/form-data" indicamos que el formulario va a contener 
un archivo
 -->
<springform:form modelAttribute="nuevoLibro" action="guardarNuevoLibro" enctype="multipart/form-data" >
	titulo: <springform:input path="titulo"/> 
	<span style="color: red"><springform:errors path="titulo"/></span>
	<br>
	
	alta: <springform:checkbox path="alta"/> 
	<span style="color: red"><springform:errors path="alta"/></span>
	<br>
	
	precio: <springform:input path="precio"/>
	<span style="color: red"><springform:errors path="precio"/></span>
	<br>
	
	categor?a: <springform:select path="idCategoria">
					<springform:options items="${categorias}"></springform:options><br>
				</springform:select>
	
	portada: <springform:input path="portada" type="file" /> <br>
	
	<input type="submit" value="Registrar Libro">
</springform:form>


</body>
</html>














