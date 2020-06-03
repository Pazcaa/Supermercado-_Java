<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="" />
  <jsp:param name="title" value="UF2406_E1" /> 
</jsp:include>

<div class="centrar">

<h5>Tus datos son:</h5>

<p>Nombre de usario: ${ cookie['cNombre'].value } </p>
<p>Color: ${ cookie['cColor'].value } </p>

</div>


<%@ include file="includes/pie-pagina.jsp"  %>