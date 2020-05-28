<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Inicio";  %>
<%@ include file="includes/cabecera.jsp"  %>


<h1> Página Principal </h1>

<%
// Esto es codigo java
out.print("<p> Esta línea esta en Java  </p>");

%>
<a href="MiPrimerServlet?nombre=paz&apellido=caamano&email=aaa@aaa.com"><h5>Mi primer servlet Ejemplo</h5></a>
<br>
<a href="formulario-cv.jsp"> Formulario CV</a>
<br>
<a href="getYpost.jsp"> Ejemplo de Get Y Post</a>
<br>
<a href="usuarios"> ver usuarios en tabla</a>
<br>
<a href="productos"> ver productos en tabla</a>
<br>
<a href="producto"> Crear producto</a>
<br>
<a href="usuario"> Crear usuario</a>



<%@ include file="includes/pie-pagina.jsp"  %>


