package com.ipartek.formacion;


import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;

/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class BuscarProductoporIdDAO {

	public static void main(String[] args) {
		

		ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
		
		System.out.println("Listado de Productos");
		System.out.println("---------------------------------------------");
		
		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}
		
		try (Scanner sc = new Scanner(System.in)){
			
			System.out.println("Dime el id del producto que desea");
			int id = Integer.parseInt(sc.nextLine());
			
			Producto p = dao.getById(id);
			System.out.println(p);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
