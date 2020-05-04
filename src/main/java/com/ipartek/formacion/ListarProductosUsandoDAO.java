package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class ListarProductosUsandoDAO {

	public static void main(String[] args) {
		

		ProductoDAO dao = ProductoDAO.getInstance();
		
		ArrayList<Producto> productos = dao.getAll();
		
		System.out.println("Listado de Productos");
		System.out.println("---------------------------------------------");
		
		for (Producto p : productos) {
			System.out.println(p);
		}
		
	}
}
