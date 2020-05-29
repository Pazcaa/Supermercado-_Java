<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>

<div class="centrar">
<h1>Formulario para Crear/Modificar Usuario</h1>

<p>${mensaje}</p>

<form action="usuario" method="post">
	<div class="form-group">
	<label for="id"> Id:</label>
	<input type="text" name="id" id="id" value="${usuario.id}" placeholder="ID solo para leer" readonly>
	</div>
	<div class="form-group">
	<label for="nombre"> Usuario:</label>
	<input type="text" name="nombre" id="nombre" value="${usuario.nombre}" placeholder="Escribe el nombre del Usuario">
	</div>
	<input type="submit" class="btn btn-warning" value="Guardar">
</form>

<p><a href="usuario">Crear Nuevo Usuario</a></p>

<p><a href="usuarios">Lista de Usuarios</a></p>
</div>

<%@ include file="includes/pie-pagina.jsp"  %>


