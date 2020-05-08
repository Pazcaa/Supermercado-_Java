package com.ipartek.formacion;


import java.util.ArrayList;


import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class ListarProductosUsandoDAO {

	public static void main(String[] args) {
		

		ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
		
		ArrayList<Producto> productos = dao.getAll();
		
		System.out.println("Listado de Productos");
		System.out.println("---------------------------------------------");
		
		for (Producto p : productos) {
			System.out.println(p);
		}
		
	}
}
