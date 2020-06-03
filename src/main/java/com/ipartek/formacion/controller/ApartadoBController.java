package com.ipartek.formacion.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApartadoBController
 */
@WebServlet("/apartado-b")
public class ApartadoBController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo los parametros
		String nombre = request.getParameter("name");
		String password = request.getParameter("password");
		
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm"));
		String horaConexion =  tiempo.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		String versionDelNavegador = request.getHeader("user-agent");
		
		
		
		//creo sesion
		HttpSession session = request.getSession();
		
		//guardo atributos de la sesion
		session.setAttribute("nombreUsuario", nombre);
		session.setAttribute("password", password);
		session.setAttribute("horaConexion", horaConexion);
		session.setAttribute("navegador", versionDelNavegador);
		request.setAttribute("mensaje", "Se ha creado con exito tu sesion");
			
			
		//Envio la informacion que necesito a la vista
		request.getRequestDispatcher("resultadoB.jsp").forward(request, response);
		
	
		
	}

}
