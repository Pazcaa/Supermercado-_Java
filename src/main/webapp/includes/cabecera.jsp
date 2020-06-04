<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<head>
     <!-- Required meta tags -->
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
         integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

 		<!-- Font Awesome -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
     
      <!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
 		
 		<!-- mis estilos CSS -->
     <link rel="stylesheet" href="css/estilos.css">

    <title> ${param.title} | Supermercado</title>
</head>
<body onload="init()">
    <header id="navbar" class="border-bottom shadow-sm"  > 
        <div id="navbar1" class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3">
	        <i  class="fas fa-apple-alt fa-2x"></i>
	        <i  class="fas fa-carrot fa-2x"></i>
	        <h5 class="my-0 mr-md-auto font-weight-normal"><a class="logo" href="index.jsp">Inicio</a></h5>
	      
	        <div class="dropdown">
			  <button class="btn btn-outline-warning dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			   Ejemplos
			  </button>
			 	<div class="dropdown-menu">
				  <a class="dropdown-item" href="formulario-cv.jsp">Formulario CV</a>
				  <a class="dropdown-item" href="getYpost.jsp">Ejemplo de Get Y Post</a>
				  <a class="dropdown-item" href="cookies.jsp">Ejemplo Cookie</a>
				  <a class="dropdown-item" href="apartadoA.jsp">UF2406_E1 ApartadoA</a>
				   <a class="dropdown-item" href="apartadoB.jsp">UF2406_E1 ApartadoB</a>
				</div>
			</div>
		        <nav class="my-2 my-md-0 mr-md-3">
		        <c:if test="${not empty usuario_login }">
		          <a class="p-2 text-dark ${ ( 'usuarios' eq param.pagina ) ? 'active' : '' } " href="usuario">Usuarios</a>
		       
		          <a class="p-2 text-dark ${ ( 'productos' eq param.pagina ) ? 'active' : '' } " href="productos">Productos</a>
		         
		          <a class="p-2 text-dark active">${usuario_login.nombre}</a>
		        </c:if> 
		        	
		        </nav>
	       
				       
	        <div>
	        	<c:if test="${empty usuario_login }">
	       		 <a class="btn btn-outline-warning ${ ( 'login' eq param.pagina ) ? 'active' : '' }" href="login.jsp">Iniciar Sesion</a>
	       		 </c:if>
	       		 
	       		 <c:if test="${not empty usuario_login }">
	       		  <a class="btn btn-outline-warning" href="logout">Cerrar Sesion</a>	 
	       		 </c:if>
	       		 
	        </div>
      </div>
    </header>

<main class="container">

<jsp:include page="alerta.jsp"></jsp:include>
