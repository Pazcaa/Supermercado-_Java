package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOimpl;

/**
 * Servlet implementation class UsuarioEliminarController
 */
@WebServlet("/usuario-eliminar")
public class UsuarioEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llamar parametros
		String idParameter = request.getParameter("id");
		int id = Integer.parseInt(idParameter);
		
		UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
		String mensaje = "";
		
		try {
			Usuario u = dao.delete(id);
			mensaje = "Se ha eliminado el usuario " + u.getNombre();
			
		} catch (Exception e) {
			mensaje = "ERROR " + e.getMessage();
			e.printStackTrace();
		}
		
		//Enviar a la vista
		ArrayList<Usuario> usuarios = dao.getAll();
		request.setAttribute("Usuarios", usuarios);
		request.setAttribute("mensaje", mensaje);
		
		request.getRequestDispatcher("tabla-usuarios.jsp").forward(request, response);
		
		
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
