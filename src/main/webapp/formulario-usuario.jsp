<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>

<div class="centrar">
<h1>Formulario para Crear/Modificar Usuario</h1>


<form action="usuario" method="post" onsubmit="cifrar()">
	<div class="form-group">
	<label for="id"> Id:</label>
	<input type="text" name="id" id="id" value="${usuario.id}" placeholder="ID solo para leer" readonly>
	</div>
	<div class="form-group">
	<label for="nombre"> Usuario:</label>
	<input type="text" name="nombre" id="nombre" value="${usuario.nombre }" placeholder="Escribe el nombre del Usuario">
	</div>
	<c:if test="${ usuario.id == 0}">
	<div class="form-group">
	<label for="password"> Password:</label>
	<input type="password" name="password" id="password" value="${usuario.contrasenia }" >
	</div>
	</c:if>
	<div class="form-group">
	<label for="rol"> Rol:</label>
	<input type="text" name="rol" id="rol" value="${usuario.idRol }" >
	</div>
	<input type="submit" class="btn btn-warning" value="Guardar" >
</form>

<p><a href="usuario?id=0">Crear Nuevo Usuario</a></p>

<p><a href="usuarios">Lista de Usuarios</a></p>
</div>

<%@ include file="includes/pie-pagina.jsp"  %>


