<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="CV Resumen" /> 
</jsp:include>


<div class="centrar">

	<h1>Mostrar Resumen CV</h1>
	
	<p style="color: red;">${mensaje}</p>

	<p><span>Nombre Completo:</span> ${name}</p>
	<p><span>Clave:</span> ${password}</p>
	<p><span>Edad:</span> ${age}</p>
	<p><span>DNI:</span> ${dni}</p>
	<p><span>Nivel de Educacion:</span> ${educacion}</p>
	<p><span>Sexo:</span> ${sexo}</p>
	<p><span>Suscripcion: </span>${option}</p>
	<p><span>Comentario:</span> ${message}</p>
</div>	

<%@ include file="includes/pie-pagina.jsp"  %>