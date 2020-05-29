<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<div class="centrar">
	<h1> Tabla con Usuarios</h1>

	<div class="alert alert-danger" role="alert">
 		 <p>${mensaje}</p>
	</div>

	<p><a href="usuario">Formulario para crear nuevo producto</a></p>


<table id="tabla" class="table table-bordered">
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
 					<a href="usuario?id=${u.id}"><i class="fas fa-edit fa-lg logo"></i>Editar</a>
 					<a href="usuario-eliminar?id=${u.id}"><i class="fas fa-trash fa-lg logo"></i>Eliminar</a>
 				</td>
 			</tr>
 			</c:forEach>
 		</tbody>
	</table>
</div>	
<%@ include file="includes/pie-pagina.jsp"  %>



