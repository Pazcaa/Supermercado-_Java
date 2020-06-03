package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOimpl;

/**
 * Servlet implementation class UsuarioGuardarController
 */
@WebServlet("/usuario")
public class UsuarioGuardarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAOimpl daoUsuario = UsuarioDAOimpl.getInstance();
	private static String VIEW_LIST = "tabla-usuarios.jsp";
	private static String VIEW_FORM = "formulario-usuario.jsp";
	
	/**
	 * Si nos viene el parametro ID , buscar el usuario y mostrarlo en el formulario. <br>
	 * Si no viene parametro ID, listamos todos los usuarios <br>
	 *	 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParameter = request.getParameter("id");
		String view = VIEW_LIST;
		
		try {
			
			if (idParameter == null) { //Listar Usuarios
				
				request.setAttribute("Usuarios", daoUsuario.getAll());
			}else {
				
				view = VIEW_FORM;  // Mostrar formulario
				int id = Integer.parseInt(idParameter);
				if (id == 0) {
					request.setAttribute("usuario", new Usuario()); //creo un nuevo usuario
				}else {
					request.setAttribute("usuario", daoUsuario.getById(id)); //edito un usuario
				}
				
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}finally {
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * Guardamos los datos del formulario, si id == 0 INSERT else UPDATE
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger los valores del formulario
		String idParameter = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String idRol = request.getParameter("rol");
		
		Usuario usuario = new Usuario();
		
		try {
			
			int id = Integer.parseInt(idParameter);
			int rol = Integer.parseInt(idRol);
			
			usuario.setId(id);
			usuario.setNombre(nombre);
			usuario.setIdRol(rol);
			
			if (id == 0) {
				//guardamos contraseña hash del formulario
				usuario.setContrasenia(password);
				daoUsuario.insert(usuario);
				
			}else {
				
				//recupero la contrseña de la bbdd TODO mirar como cambiarla 
				Usuario uGuardado = daoUsuario.getById(id);
				usuario.setContrasenia(uGuardado.getContrasenia());
				
				daoUsuario.update(usuario);
			}
			
			request.setAttribute("alerta", new Alerta("success", "Se han actualizado los datos con exito"));
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alerta", new Alerta("danger", "lo sentimos, pero ha ocurrido una excepcion" + e.getMessage()));
			
			
		}finally {
			
			//enviar datos a la vista
			request.setAttribute("usuario", usuario);
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher("VIEW_FORM").forward(request, response);
		}
	}//doPost

}
