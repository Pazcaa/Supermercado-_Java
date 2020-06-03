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

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOimpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//paso los parametros
		String nombre = request.getParameter("name");
		String password = request.getParameter("password");
		String idioma = request.getParameter("idioma");
		String language = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		String mensaje = "";
		
		switch (language) {
		case "en":
			idioma = "ingles";
			mensaje = "Welcome to your sesion";
			break;
		case "eu":
			idioma = "euskera";
			mensaje = "Ongi etorri, tu sesion ha empezado con exito";
			break;
		case "es":
			idioma = "castellano";
			mensaje = "Bienvenido a tu sesion";
			break;

		default:
			break;
		}
		
		//recoger una cookie con la ultima visita e idioma
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm"));
		Cookie cUltimaVisita = new Cookie("Ultima_Visita", formattedDate );
		
		cUltimaVisita.setMaxAge(60 *1 *60 *24 *365);// 1 año
		response.addCookie(cUltimaVisita);
		
		Cookie cIdioma = new Cookie("cIdioma", language);
		if (recuerdame != null) {
			cIdioma.setMaxAge(60 *1 *60 *24 *365);// 1 año
			
		}else {
			cIdioma.setMaxAge(0);
		}
		response.addCookie(cIdioma);// guarda mi desicion en la cookie
		
		
		HttpSession session = request.getSession();
		
		//validar contra BBDD
		UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
		Usuario usuario = dao.existe(nombre, password);
		
		if (usuario != null) {
			
			session.setMaxInactiveInterval(60 * 5);//tras 5 min sin peticiones se desconecta automaticamente
			session.setAttribute("usuario_login", usuario);
			
			
			request.setAttribute("idioma", idioma);
			request.setAttribute("language", language);
			
			
			
			request.setAttribute("alerta", new Alerta("success", mensaje + ", tu ultima visita fue el " + formattedDate));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else {
			
			request.setAttribute("alerta", new Alerta("warning", "Sus datos son incorrectos, vuelva ha intentarlo"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	
	}

}
