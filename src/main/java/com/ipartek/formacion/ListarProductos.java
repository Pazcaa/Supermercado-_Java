package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;



/**
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */

public class ListarProductos {

	public static void main(String[] args) {
		
		
		final String SQL = "SELECT id, nombre FROM producto ORDER BY id DESC;";
		
		
		
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				ResultSet rs = pst.executeQuery();)
		{
		   
		 //conectarnos con la bbdd del supermercado
	     //Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
		   //conexion = ConnectionManager.getConnection();
		   
		   //System.out.println("Hemos establecido la conexion con exito");
		   
		   //Realizar una consulta
		   //pst = conexion.prepareStatement(SQL);
		   //rs = pst.executeQuery();
		   
			System.out.println("Listado de Productos");
			System.out.println("---------------------------------------------");
		   
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
