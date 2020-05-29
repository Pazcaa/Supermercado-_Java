<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>

<div class="centrar">
<h1> Página Principal </h1>

<%
// Esto es codigo java
out.print("<p> Esta línea esta en Java  </p>");

%>
<a class="logo" href="MiPrimerServlet?nombre=paz&apellido=caamano&email=aaa@aaa.com"><h6>Mi primer servlet Ejemplo</h6></a>
<br>
<a class="logo" href="formulario-cv.jsp"><h6>Formulario CV</h6></a>
<br>
<a class="logo" href="getYpost.jsp"><h6> Ejemplo de Get Y Post</h6></a>
<br>
<a class="logo" href="usuarios"><h6>ver usuarios en tabla</h6></a>
<br>
<a class="logo" href="productos"><h6>ver productos en tabla</h6></a>
<br>
<a class="logo" href="producto"><h6>Crear producto</h6></a>
<br>
<a class="logo" href="usuario"><h6>Crear usuario</h6></a>
</div>


<%@ include file="includes/pie-pagina.jsp"  %>


