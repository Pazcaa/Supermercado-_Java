package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;

/**
 * Servlet implementation class ProductoEliminarController
 */
@WebServlet("/producto-eliminar")
public class ProductoEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//<td><a href="producto-eliminar?id=${p.id}">ELIMINAR</a></td>
		//Obtener los parametros
		String parameterId = request.getParameter("id");
		int id = Integer.parseInt(parameterId);
		
		//Llamar al DAO
		ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
		String mensaje = "";
		
		try {
			Producto p = dao.delete(id);
			mensaje = "Eliminado el producto " + p.getNombre();
			
		} catch (Exception e) {
			mensaje = "ERROR " + e.getMessage();
			e.printStackTrace();
		}
		
		//Enviar datos a la vista
		ArrayList<Producto> productos = dao.getAll();
		request.setAttribute("Productos", productos);
		request.setAttribute("mensaje", mensaje);
		
		request.getRequestDispatcher("productos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
