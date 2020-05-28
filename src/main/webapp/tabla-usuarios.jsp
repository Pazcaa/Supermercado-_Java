<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Productos";  %>
<%@ include file="includes/cabecera.jsp"  %>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

	<a href="index.jsp">Volver</a>

	<h1> Tabla con Usuarios</h1>

	<p>${mensaje}</p>

	<p><a href="usuario">Formulario para crear nuevo producto</a></p>


<table id="tabla">
	<thead>
  		<tr>
   			 <td>Id</td>
   			 <td>Nombre</td> 
   			 <td>Operaciones</td> 
 		</tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${Usuarios}" var="u">
 			<tr> 
 				<td>${u.id}</td>
 				<td>${u.nombre}</td>
 				<td>
 					<a href="usuario?id=${u.id}">EDITAR</a>
 					<a href="usuario-eliminar?id=${u.id}">ELIMINAR</a>
 				</td>
 			</tr>
 			</c:forEach>
 		</tbody>
	</table>	
<%@ include file="includes/pie-pagina.jsp"  %>



