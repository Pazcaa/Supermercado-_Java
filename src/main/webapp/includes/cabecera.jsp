<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title> <%=title%> | Supermercado</title>
</head>
<body>
    <header id="navbar"  > 
        <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom shadow-sm">
        <i  class="fas fa-apple-alt"></i>
        <i  class="fas fa-carrot"></i>
        <h5 class="my-0 mr-md-auto font-weight-normal"><a class="logo" href="index.jsp">Supermercado</a></h5>
        <nav class="my-2 my-md-0 mr-md-3">
          <a class="p-2 text-dark" href="formulario.html">Registro Producto</a>
          <a class="p-2 text-dark" href="listado.html">Listado de Productos</a>
        </nav>
        <a class="btn btn-outline-warning" href="login.html">Login Admnistrador</a>
      </div></header>

<main class="container">
