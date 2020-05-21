<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<a href="index.jsp">Volver</a>

<h1> Tabla con Usuarios</h1>


<style>
td {border: 1px solid black}
</style>

<%
// recogemos la informacion "atributo" enviada desde el controlador
ArrayList<Usuario> usuarios = (ArrayList<Usuario>)request.getAttribute("Usuarios");
%>



<table style="width:100%; border: 1px solid black">
  <tr>
    <th>id</th>
    <th>nombre</th> 
  </tr>
  
  <% for (Usuario u : usuarios){%>
  
  
  <tr>
  <td><%=u.getId() %></td>
  <td><%=u.getNombre() %></td>
  </tr>
  
  <% } %>
  
</table>

