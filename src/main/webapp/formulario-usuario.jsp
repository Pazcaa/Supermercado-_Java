<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Usuario";  %>
<%@ include file="includes/cabecera.jsp"  %>

<a href="index.jsp">Volver</a>
<h1>Formulario para Crear/Modificar Usuario</h1>

<p>${mensaje}</p>

<form action="usuario" method="post">

	<label for="id"> Id:</label>
	<input type="text" name="id" id="id" value="${usuario.id}" placeholder="ID solo para leer" readonly>
	<br>
	<label for="nombre"> Usuario:</label>
	<input type="text" name="nombre" id="nombre" value="${usuario.nombre}" placeholder="Escribe el nombre del Usuario">
	<br>
	<input type="submit" value="Guardar">
</form>

<p><a href="usuario">Crear Nuevo Usuario</a></p>

<p><a href="usuarios">Lista de Usuarios</a></p>

<%@ include file="includes/pie-pagina.jsp"  %>


