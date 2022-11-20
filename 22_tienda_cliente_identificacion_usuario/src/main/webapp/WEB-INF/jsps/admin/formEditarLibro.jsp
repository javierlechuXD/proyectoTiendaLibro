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

actualiza los datos del libro:
<!-- 
con enctype="multipart/form-data" indicamos que el formulario va a contener 
un archivo
 -->
<springform:form modelAttribute="libro" action="guardarCambiosLibro" enctype="multipart/form-data" >
	titulo: <springform:input path="titulo"/> <br>
	alta: <springform:checkbox path="alta"/> <br>
	precio: <springform:input path="precio"/> <br>
	categoria: <springform:select path="idCategoria">
					<springform:options items="${categorias}"/>
			   </springform:select><br>
	portada: <springform:input path="portada" type="file" /> <br>
	<springform:hidden path="id"/>
	<input type="submit" value="GUARDAR CAMBIOS">
</springform:form>


</body>
</html>














