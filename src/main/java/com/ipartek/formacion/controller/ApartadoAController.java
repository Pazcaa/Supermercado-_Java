package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApartadoAController
 */
@WebServlet("/apartado-a")
public class ApartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recupero parametros
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		
		//creo cookie de nombre de usuario y color elegido
		Cookie cNombre = new Cookie("cNombre", nombre);
		cNombre.setMaxAge(60 *1);//1 minuto
		response.addCookie(cNombre);
		
		Cookie cColor = new Cookie("cColor", color);
		cColor.setMaxAge(60 *1);//1 minuto
		response.addCookie(cColor);
		
		
		//guardo mis cookies
		Cookie[] cookies = request.getCookies();
		
		
		//las envio a la vista
		//request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
		
		response.sendRedirect("resultadoA.jsp");
	
		
	}

}
