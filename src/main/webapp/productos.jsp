<%@page import="com.ipartek.formacion.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">Volver</a>

<h1> Tabla con Productos</h1>

<p>${mensaje}</p>


<table>
	<thead>
  		<tr>
   			 <td>Id</th>
   			 <td>Nombre</th> 
 		</tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${Productos}" var="p">
 			<tr> 
 				<td>${p.id}</td>
 				<td>${p.nombre}</td>
 				<td><a href="producto-eliminar?id=${p.id}">ELIMINAR</a></td>
 			</tr>
 		</c:forEach>
 	</tbody>
  
</table>
	
</body>
</html>