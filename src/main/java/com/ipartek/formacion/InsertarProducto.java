package com.ipartek.formacion;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;




/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class InsertarProducto {

	public static void main(String[] args) {
	
		
		
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
		Connection conexion = null;
		PreparedStatement pst = null;
		boolean continuar = true;
		
		
		try(Scanner sc = new Scanner(System.in);)
		{
			
			
			//comprobar que tenemos el .jar de MySQL
		  // Class.forName("com.mysql.jdbc.Driver");
			
		  // System.out.println("Existe el .jar para MySQL");
		   
		 //conectarnos con la bbdd del supermercado
		   //Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
			conexion = ConnectionManager.getConnection();
		  // System.out.println("Hemos establecido la conexion con exito");
		   
		   //Realizar una consulta
			pst = conexion.prepareStatement(SQL);
		   //PreparedStatement pst = conexion.prepareStatement(SQL);
		   
		   
			
		
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
