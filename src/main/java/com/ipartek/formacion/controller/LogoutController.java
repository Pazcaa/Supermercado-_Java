package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String language = "";
		String mensaje = "";
		
		
		//Recupero los valores guardados en las Cookies
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("cIdioma".equals(c.getName())) {
					language = c.getValue();
					break;	
				}
			}
		}
		
		switch (language) {
		case "es":
			mensaje = "Hasta pronto";
			break;
		case "eu":
			mensaje = "Agur";
			break;

		default:
			mensaje = "See you soon!";
			break;
		}
		
		
		
		
		request.setAttribute("alerta", new Alerta("success", mensaje));
		
		//ATENCION!!! hacerlo ultimo, nunca antes de las cookies
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		//usuarios conectados recuperar y actualizar
				ServletContext sc = request.getServletContext();
				int usuariosConectados = (int)sc.getAttribute("usuarios_conectados");
				sc.setAttribute("usuarios_conectados", --usuariosConectados);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
