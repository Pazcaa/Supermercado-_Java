<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="UF2406_E1" /> 
</jsp:include>

<div class="centrar">

<form action="apartado-b" class="form-signin content" method="post">
<h1 class="h3 mb-3 font-weight-normal">Crear Sesion</h1>
	  <div class="form-group">
		  <label for="name">Nombre</label>
		  <input type="text" name= "name" id="name" class="form-control" placeholder="nombre" required autofocus>
	  </div>
	  <div class="form-group">
		  <label for="password">Contraseña</label>
		  <input type="password" name="password" id="password" class="form-control" placeholder="Contraseña" required>
	  </div>
	
  <button class="btn btn-lg btn-primary btn-block" type="submit">Crear</button>
</form>
</div>


<%@ include file="includes/pie-pagina.jsp"  %>
