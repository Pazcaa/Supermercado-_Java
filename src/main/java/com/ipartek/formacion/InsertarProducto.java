package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class InsertarProducto {

	public static void main(String[] args) {
		
		
		
		final String URL ="jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
		boolean continuar = true;
		
		
		try
		{
			Scanner sc = new Scanner(System.in);
			
			//comprobar que tenemos el .jar de MySQL
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Existe el .jar para MySQL");
		   
		 //conectarnos con la bbdd del supermercado
		   Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
		   System.out.println("Hemos establecido la conexion con exito");
		   
		   //Realizar una consulta
		   PreparedStatement pst = conexion.prepareStatement(SQL);
		   
		   
			
		
		   //TODO pedir el nombre del producto por pantalla, usando el Scanner
		   System.out.println("dime un producto a guardar");
		  
		   
		   do {
			   String nombre = sc.nextLine();
				
				
				//cambiamos el 1º ? de la SQL por "Galletitas Saladas"
				//"INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); "
				pst.setString(1, nombre);
			
				try {
					int AffectedRows = pst.executeUpdate();
					// affectedRows es el numero de registros ingresados
					
					
					if (AffectedRows == 1) {
						System.out.println("El producto se ha guardado con exito");
						continuar = false;
					}
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
