<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Formulario" /> 
</jsp:include>

<div class="centrar">
<h1>Formulario para Crear/Modificar Producto</h1>

	<div class="row">
		<div class="col-8">
			<form action="producto" method="post">
				<div class="form-group">
					<label for="id"> Id:</label>
					<input type="text"  class="form-control"  name="id" id="id" value="${producto.id}" placeholder="ID solo para leer" readonly>
				</div>
				<div class="form-group">
					<label for="nombre"> Producto:</label>
					<input type="text" class="form-control" required autofocus name="nombre" id="nombre" value="${producto.nombre}" placeholder="Escribe el nombre del Producto">
				</div>
				<div class="form-group">
					<label for="precio"> Precio:</label>
					<input type="text" class="form-control" name="precio" id="precio" value="${producto.precio}">
				</div>
				<div class="form-group">
					<label for="imagen"> Imagen:</label>
					<input type="text" class="form-control" name="imagen" id="imagen" value="${producto.imagen}" placeholder="Insertar imagen del producto">
				</div>
					<input type="submit" class="btn btn-warning" value="Guardar">
			</form>
			<p><a class="logo" href="producto">Crear Nuevo Producto</a></p>
			<p><a class="logo" href="productos">Lista de Productos</a></p>
		</div>
		<div class="col-4">
			<img alt="imagen insertada" class="img-thumbnail" src="${producto.imagen}">
		</div>
	</div>
</div>

<%@ include file="includes/pie-pagina.jsp"  %>

