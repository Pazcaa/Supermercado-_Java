<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="cookies" />
  <jsp:param name="title" value="Cookies" /> 
</jsp:include>

<h1>Ejemplo de Uso de Cookies</h1>

<p>Se puede usar el inspector de codigo para ver la cookie, eso se hace en la pestaña <b>storage</b></p>
<br>
<p>Su ultima visita fue el <b> ${ cookie['Ultima_Visita'].value } </b></p>

<form action="cookies" method="post">

	<input type="text" name="email" placeholder="Tu Email" value="${ cookie['cEmail'].value }">
	<br>
	<input type="checkbox" id="recuerdame" name="recuerdame" ${ (not empty cookie['cEmail'].value) ? "checked" : ""  } >Recuerdame
	<br>
	<input type="submit" value="Guardar Cookies">
	
</form>






<jsp:include page="includes/pie-pagina.jsp"></jsp:include>
