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
 * Servlet implementation class TablaProductoController
 */
@WebServlet("/productos")
public class TablaProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//conseguir los productos de la base de datos
				ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
				ArrayList<Producto> productos = dao.getAll();
				
				//Enviar informacion a la vista
				request.setAttribute("Productos", productos);
				
				//ir a la nueva vista o jsp
				request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

}
