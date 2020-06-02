<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

<div class="centrar">
<form action="login" class="form-signin content" method="post">

  <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
	  <div class="form-group">
		  <label for="name">Nombre</label>
		  <input type="text" name= "name" id="name" class="form-control" placeholder="nombre" required autofocus>
	  </div>
	  <div class="form-group">
		  <label for="password">Contraseña</label>
		  <input type="password" name="password" id="password" class="form-control" placeholder="Contraseña" required>
	  </div>
	  <div>
	 	 <label for="idioma">Idioma:</label>	
	 	 	<select class="casillas form-control" name="idioma" id="idioma">
				<option value="en" ${(language eq "u")? "selected": ""}>Ingles</option>
				<option value="eu" ${(language eq "b")? "selected": ""}>Euskera</option>
				<option value="es" ${(language eq "o")? "selected": ""}>Español</option>
			</select>
	  </div>
	  
	  
	  <div class="checkbox mb-3">
	    <label>
	      <input type="checkbox" name="recuerdame" value="remember-me"> Recordar mis datos
	    </label>
	  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar</button>

</form>
</div>

<jsp:include page="includes/pie-pagina.jsp"></jsp:include>



