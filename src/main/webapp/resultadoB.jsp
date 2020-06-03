<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="UF2406_E1" /> 
</jsp:include>

<div class="centrar">

<h5> ${mensaje} </h5>

<p>Hora de inicio: ${horaConexion} </p>
<p>Nombre de usuario: ${nombreUsuario} </p>
<p>Navegador utilizado: ${navegador} </p>



</div>


<%@ include file="includes/pie-pagina.jsp"  %>