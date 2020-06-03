<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="UF2406_E1" /> 
</jsp:include>

<div class="centrar">

	<form action="apartado-a" method="post">
	
	<label for="nombre">Usuario:</label>
	<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Escribe tu nombre de usuario" required autofocus>
	
	
	 <label for="color">Color:</label>	
	 	 	<select class="casillas form-control" name="color" id="color">
				<option value="Negro" >Negro</option>
				<option value="Rojo" selected >Rojo</option>
				<option value="Azul" >Azul</option>
			</select>
		<br>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
	
	</form>

</div>


<%@ include file="includes/pie-pagina.jsp"  %>