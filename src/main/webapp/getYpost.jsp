<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ejemplo de Gets y Post</h1>

<h2>Ejemplo de GET</h2>
<p>Es necesario un enlace, aunque se puede hacer desde un formulario si cambiamos el METHOD</p>
<p>Nomlamente es para solicitar informacion al servidor, aunque tambien lo usaremos para eliminar</p>

	

<a href="sumar?op1=2&op2=3"> Vamos a sumar 2 + 3</a>

<h2>Ejemplo de POST</h2>
<p>Siempre es necesario un formulario, normalmente las peticiones POST sirven para crear o modificar recursos</p>

<p style="color:red;"> ${mensaje}<p>

<form action="sumar" method="post">
<input type="number" name="op1" placeholder="Introduce un numero">
<br>
<input type="number" name="op2" placeholder="Introduce un numero">
<br>
<input type="submit" value="sumar">
<br>

</form>

<h2>RESULTADO</h2>
	${resultado}

</body>
</html>