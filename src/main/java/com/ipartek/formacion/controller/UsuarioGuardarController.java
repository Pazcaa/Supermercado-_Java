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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String idParameter = request.getParameter("id");
			Usuario usuario = new Usuario();
			
			if (idParameter != null) {
				
				int id = Integer.parseInt(idParameter);
				UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
				usuario = dao.getById(id);
			}
			
			request.setAttribute("usuario", usuario);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}finally {
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-usuario.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "";
		Usuario usuario = new Usuario();
		
		try {
			//recoger los valores del formulario
			String idParameter = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			
			int id = Integer.parseInt(idParameter);
			
			UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
			
			usuario.setId(id);
			usuario.setNombre(nombre);
			
			if (id == 0) {
				
				dao.insert(usuario);
				
			}else {
				dao.update(usuario);
			}
			
			mensaje = "Usuario guardado con exito";
			
		} catch (Exception e) {
			mensaje = "lo sentimos, pero ha ocurrido una excepcion" + e.getMessage();
			e.printStackTrace();
		}finally {
			//enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("usuario", usuario);
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-usuario.jsp").forward(request, response);
		}
	}//doPost

}