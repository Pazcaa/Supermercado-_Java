<%@page import="com.ipartek.formacion.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Productos" /> 
</jsp:include>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div class="centrar">
<h1> Tabla con Productos</h1>

<div class="alert alert-danger" role="alert">
  <p>${mensaje}</p>
</div>

<p><a href="producto">Formulario para crear nuevo producto</a></p>

<div class="centrar">
<table id="tabla" class="table table-bordered">
	<thead>
  		<tr>
   			 <td>Id</td>
   			 <td>Nombre</td> 
   			 <td>Precio</td> 
   			 <td>Imagen</td> 
   			 <td>Operaciones</td> 
 		</tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${Productos}" var="p">
 			<tr> 
 				<td>${p.id}</td>
 				<td>${p.nombre}</td>
 				<td>${p.precio} &euro;</td>
 				<td><img src="${p.imagen}" alt="Imagen de ${p.nombre}"></td>
 				<td>
 					<a href="producto?id=${p.id}"><i class="fas fa-edit fa-lg logo"></i>Editar</a><br>
 					<a href="producto-eliminar?id=${p.id}"><i class="fas fa-trash fa-lg logo"></i>Eliminar</a>
 				</td>
 			</tr>
 			</c:forEach>
 		</tbody>
	</table>
</div>
	<%@ include file="includes/pie-pagina.jsp"  %>
	
