<%@page import="com.ipartek.formacion.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Productos";  %>
<%@ include file="includes/cabecera.jsp"  %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<a href="index.jsp">Volver</a>

<h1> Tabla con Productos</h1>

<p>${mensaje}</p>

<p><a href="producto">Formulario para crear nuevo producto</a></p>


<table id="tabla">
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
 					<a href="producto?id=${p.id}">EDITAR</a>
 					<a href="producto-eliminar?id=${p.id}">ELIMINAR</a>
 				</td>
 			</tr>
 			</c:forEach>
 		</tbody>
	</table>
	<%@ include file="includes/pie-pagina.jsp"  %>
	
