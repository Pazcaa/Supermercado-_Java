<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="formulario" />
  <jsp:param name="title" value="Formulario" /> 
</jsp:include>

<div class="centrar">
<h1>Formulario para Crear/Modificar Producto</h1>

<p>${mensaje}</p>

<form action="producto" method="post">
	<div class="form-group">
	<label for="id"> Id:</label>
	<input type="text" name="id" id="id" value="${producto.id}" placeholder="ID solo para leer" readonly>
	</div>
	<div class="form-group">
	<label for="nombre"> Producto:</label>
	<input type="text" name="nombre" id="nombre" value="${producto.nombre}" placeholder="Escribe el nombre del Producto">
	</div>
	<div class="form-group">
	<label for="precio"> Precio:</label>
	<input type="number" name="precio" id="precio" value="${producto.precio}" placeholder="Escribe el nombre del Producto">
	</div>
	<div class="form-group">
	<label for="imagen"> Imagen:</label>
	<input type="text" name="imagen" id="imagen" value="${producto.imagen}" placeholder="Escribe el nombre del Producto">
	</div>
	<input type="submit" class="btn btn-warning" value="Guardar">
</form>

<p><a href="producto">Crear Nuevo Producto</a></p>

<p><a href="productos">Lista de Productos</a></p>
</div>


<%@ include file="includes/pie-pagina.jsp"  %>

