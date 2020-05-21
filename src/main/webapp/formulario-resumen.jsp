<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="index.jsp">Volver pagina principal</a>

	<h1>Mostrar Resumen CV</h1>
	
	<p style="color: red;">${mensaje}</p>

	<p>Nombre Completo: ${name}</p>
	<p>Clave: ${password}</p>
	<p>Edad: ${age}</p>
	<p>DNI: ${dni}</p>
	<p>Nivel de Educacion: ${education}</p>
	<p>Sexo: ${sexo}</p>
	<p>Suscripcion: ${option}</p>
	<p>Comentario: ${message}</p>
	

</body>
</html>