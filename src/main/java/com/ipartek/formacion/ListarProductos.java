package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.Producto;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class ListarProductos {

	public static void main(String[] args) {
		
		
		
		final String URL ="jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "SELECT id, nombre FROM producto ORDER BY nombre ASC;";
		
		
		
		try
		{
			//comprobar que tenemos el .jar de MySQL
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Existe el .jar para MySQL");
		   
		 //conectarnos con la bbdd del supermercado
		   Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
		   System.out.println("Hemos establecido la conexion con exito");
		   
		   //Realizar una consulta
		   PreparedStatement pst = conexion.prepareStatement(SQL);
		   ResultSet rs = pst.executeQuery();
		   
			System.out.println("Listado de Productos");
			System.out.println("______________________________________________");
		   
		   //consultar 1 a 1 los resultados hasta que no existan mas registros
		   while (rs.next()) {
			   
			   int id = rs.getInt("id");
			   String nombre = rs.getString("nombre");
			   
			   Producto p = new Producto(nombre);
			   p.setId(id);
			   
			   
			System.out.println(p);
			//System.out.println(p.toString()); //es lo mismo que el comando anterior
		}
		  
		   
		   
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
		
	
		
		

	}

}
