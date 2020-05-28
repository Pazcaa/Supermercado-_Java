<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String title = "Formulario CV";  %>
<%@ include file="includes/cabecera.jsp"  %>	
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<a href="index.jsp"><h6>Volver pagina principal</h6></a>

	<h1>Formulario Completo</h1>

	<c:if test="${not empty validation}">
		<div style="padding:20px; background-color: #DDD; color:#000; ">
			<ol>
				<c:forEach items="${validation}" var="val">
					<li>${val}</li>
				</c:forEach>
			</ol>
		</div>
	</c:if>

	
		<div class="container centrar">
			<h1 class="formulario">Rellena tu CV</h1>
			
			<form novalidate action="curriculum" method="post">
				<!--action es lo que lee mi controller -->

				<label for="nombre" class="obligatoria">Nombre*</label> <br /> 
				<input class="casillas" type="text" id="nombre" name="nombre" value="${nombre}"
					placeholder="minimo 3, maximo 6" maxlength="80"
					pattern="[A-Za-z]{2,80}" autofocus required><br /> 
					
				<label for="apellido" class="obligatoria">Apellido*</label> <br /> 
				<input class="casillas" type="text" id="apellido" name="apellido" value="${apellido}"
					placeholder="Apellido" maxlength="80" pattern="[A-Za-z]{2,80}"
					required><br /> 
				
				<label for="password" class="obligatoria">Contraseña*</label><br /> 
				<input class="casillas" type="password"
					id="password" name="password" value="${password}"
					placeholder="Minimo 4 caracteres" maxlength="10" /><br /> 
				
				<label for="age">Edad</label> <br /> 
				<input class="casillas"
					type="number" id="age" step="1" name="edad" value="${age}"
					placeholder="000-999" /><br /> 
					
				<label for="dni">DNI</label> <br />
				<input class="casillas" type="text" id="dni" name="dni" value="${dni}"
					placeholder="11111111" /><br /> 
					
				<label for="education">Nivel de estudios:</label> <br />	
				<select class="casillas" name="educacion" id="education">
					<option value="u" ${(education eq "u")? "selected": ""}>Universitario</option>
					<option value="b" ${(education eq "b")? "selected": ""}>Bachiller</option>
					<option value="o" ${(education eq "o")? "selected": ""}>Otro</option>
				</select>

				<fieldset>
					<legend>Sexo:</legend>
					
						<input type="radio" id="sex" name="sexo" value="hombre" ${(sex eq "hombre")? "checked": ""}/>
							<label for="sex">Hombre</label> <br /> 
						<input type="radio"	id="sex" name="sexo" value="mujer" ${(sex eq "mujer")? "checked": ""} /> 
							<label for="sex">Mujer</label>
							
							<%  %>
					<br /> 
				</fieldset>


				<!-- <label for="picture">Incluir mi foto</label> 
                <input type="file" id="picture" name="Adjunto"><br /> -->

				<input type="checkbox" id="sus" name="opcion" value="si" ${(sus eq "si")? "checked": ""}/>
				<label for="sus">Suscribirme al boletin de novedades</label> <br />

				<label for="text">Comentarios:</label><br />
				<textarea class="casillas" name="message" id="text" cols="50"
					rows="10" placeholder="Tus comentarios sond e agradecer...">
				</textarea>
				<br />
				 
				<input type="submit" name="guardar" value="Guardar Cambios" />
				<input type="reset" name="borrar" value="Borrar los datos introducidos" />


			</form>
			<p>los campos con <b>*</b> son obligatorios</p>
		</div>

		


<%@ include file="includes/pie-pagina.jsp"  %>


