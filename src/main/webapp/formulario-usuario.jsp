<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="usuarios" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>

<div class="centrar">
<h1>Formulario para Crear/Modificar Usuario</h1>

	<div class="row">
		<div class="col-8">
			<form action="usuario" method="post" onsubmit="cifrar()">
				<div class="form-group">
					<label for="id"> Id:</label>
					<input type="text" class="form-control" name="id" id="id" value="${usuario.id}" placeholder="ID solo para leer" readonly>
				</div>
				<div class="form-group">
					<label for="nombre"> Usuario:</label>
					<input type="text" class="form-control"  name="nombre" id="nombre" value="${usuario.nombre }" placeholder="Escribe el nombre del Usuario" required autofocus>
				</div>
				<div class="form-group">
					<c:if test="${ usuario.id == 0}">
						<label for="password"> Password:</label>
						<input type="password" class="form-control" name="password" id="password" value="${usuario.contrasenia }"  placeholder="Escribe tu contraseña"  >
					</c:if>
				</div>
				<div class="form-group">
					<c:if test="${ usuario.id == 0}">
						<label for="rol"> Rol:</label>
						<select class="casillas form-control" name="rol" id="rol">
							<option value="1" ${(rol1 eq "1")? "selected": ""}>Usuario</option>
							<option value="2" ${(rol1 eq "2")? "selected": ""}>Administrador</option>
							<option value="3" ${(rol1 eq "3")? "selected": ""}>Rol 3</option>
							<option value="4" ${(rol1 eq "4")? "selected": ""}>Rol 4</option>
						</select>
						
					</c:if>
					<c:if test="${ usuario.id != 0}">
						<label for="rol"> Rol:</label>
						<input type="text" class="form-control" name="rol" id="rol" value="${usuario.idRol }" readonly>
					</c:if>
				</div>
					<input type="submit" class="btn btn-warning" value="Guardar" >
			</form>
			<p><a class="logo" href="usuario?id=0">Crear Nuevo Usuario</a></p>
			<p><a class="logo" href="usuarios">Lista de Usuarios</a></p>
		</div>
		<div class="col-4">
		</div>
	</div>
</div>
<%@ include file="includes/pie-pagina.jsp"  %>


