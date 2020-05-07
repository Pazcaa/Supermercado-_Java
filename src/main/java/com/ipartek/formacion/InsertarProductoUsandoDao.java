package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class InsertarProductoUsandoDao {

	public static void main(String[] args) {
	
		ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
		boolean continuar = true;
		
		try (Scanner sc = new Scanner(System.in);){
		
		   do {
			 
				try {
					
					  System.out.println("dime un producto a guardar");
					   String nombre = sc.nextLine();
					   Producto producto = new Producto();
					   producto.setNombre(nombre);
					   
					   producto = dao.insert(producto);
					   continuar = false;
					   
					
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el producto ya existe, dime otro");
				} 
		   
			
		} while (continuar);
		
		} catch (Exception e) {
			System.out.println("Tenemos un problema " + e.getMessage());
		}
			
			
		System.out.println("Agur, nos vemos otro día");
		  
	

	}//try

}
