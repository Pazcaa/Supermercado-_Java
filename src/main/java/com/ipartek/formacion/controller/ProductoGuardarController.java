package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto")
public class ProductoGuardarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo mis parametros
	
		try {
			String idParameter = request.getParameter("id");
			Producto producto = new Producto();
			
			if (idParameter != null) {
				
				int id = Integer.parseInt(idParameter);
				ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
				producto = dao.getById(id);
			}
			
			request.setAttribute("producto", producto);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}finally {
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		}
	
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String mensaje = "";
		Producto producto = new Producto();
		
		try {
			//recoger los valores del formulario
			String idParameter = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String precioParameter = request.getParameter("precio");
			String imagen = request.getParameter("imagen");
			
			int id = Integer.parseInt(idParameter);
			float precio = Float.parseFloat(precioParameter);
			
			
			ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
			
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setImagen(imagen);
			
			if (id == 0) {
				
				dao.insert(producto);
				
			}else {
				dao.update(producto);
			}
			
			mensaje = "Producto guardado con exito";
			
		} catch (Exception e) {
			mensaje = "lo sentimos, pero ha ocurrido una excepcion" + e.getMessage();
			e.printStackTrace();
		}finally {
			//enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("producto", producto);
			
			
			//ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		}
		
		
	}//doPost

}
