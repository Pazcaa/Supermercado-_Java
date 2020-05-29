package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/curriculum")
public class FormularioCompletoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> validaciones = new ArrayList<>();
		
		try {

			// recoger parametros del formulario
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String password = request.getParameter("password");
			String edad = request.getParameter("edad");
			String dni = request.getParameter("dni");
			String educacion = request.getParameter("educacion");
			String education = request.getParameter("educacion");
			String sexo = request.getParameter("sexo");
			String sex = request.getParameter("sexo");
			
			String opcion = request.getParameter("opcion");
			String sus = request.getParameter("opcion");
			String message = request.getParameter("message");

			// comprobar que se llenan los campos obligatorios
			
			if ("".equalsIgnoreCase(nombre)) {
				validaciones.add("El nombre es obligatorio");
			}
			
			if ("".equalsIgnoreCase(apellido)) {
				validaciones.add("El apellido es obligatorio");	
			}
			
			if ("".equalsIgnoreCase(password)) {
				validaciones.add("La contraseña es necesaria");
			}
			
			
			// logica de negocio
			
			String name = nombre + " " + apellido;

			switch (education) {
			case "u":
				educacion = "universitario";
				break;
			case "b":
				educacion = "bachiller";
				break;
			case "o":
				educacion = "otro";
				break;

			default:
				break;
			}//switch
			
			if ("si".equals(opcion)) {
				opcion = "Acepto la suscripcion";
			} else {
				opcion = "No acepto la suscripcion";
			}
			

			// volver a enviar los PARAMETROS recibido como ATRIBUTOS
			request.setAttribute("name", name);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("password", password);
			request.setAttribute("age", edad);
			request.setAttribute("dni", dni);
			request.setAttribute("educacion", educacion);
			request.setAttribute("education", education);
			request.setAttribute("sexo", sexo);
			request.setAttribute("sex", sex);
			
			request.setAttribute("option", opcion);
			request.setAttribute("sus", sus);
			request.setAttribute("message", message);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "lo sentimos, pero ha habido un error" + e.getMessage());

		} finally {
			
			if (validaciones.isEmpty()) {
				request.getRequestDispatcher("formulario-resumen.jsp").forward(request, response);
			}else {
				
				request.setAttribute("validation", validaciones);
				request.getRequestDispatcher("formulario-cv.jsp").forward(request, response);
			}

			
		}

	}

}
