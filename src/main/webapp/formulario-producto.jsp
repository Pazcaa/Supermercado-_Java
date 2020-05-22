<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">Volver</a>
<h1>Formulario para Crear/Modificar Producto</h1>

<p>${mensaje}</p>

<form action="producto" method="post">

	<label for="id"> Id:</label>
	<input type="text" name="id" id="id" value="${producto.id}" placeholder="ID solo para leer" readonly>
	<br>
	<label for="nombre"> Producto:</label>
	<input type="text" name="nombre" id="nombre" value="${producto.nombre}" placeholder="Escribe el nombre del Producto">
	<br>
	<input type="submit" value="Guardar">
</form>

<p><a href="producto">Crear Nuevo Producto</a></p>

<p><a href="productos">Lista de Productos</a></p>

</body>
</html>