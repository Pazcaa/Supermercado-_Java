package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class ModificarProductoPorId {
public static void main(String[] args) {
	//mostrar listado de productos
	
		// preguntar el ID del que quiere eliminar y el nombre
	final String SQL = "SELECT id, nombre FROM producto ORDER BY id DESC;";
	
	
	
	try(
			Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			Scanner sc = new Scanner(System.in);)
	{
	   
	
	   
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
	}//while
	   
	   
	   System.out.println("-------------------------------------------------------");
	   System.out.println("Dime el ID del producto que deseas cambiar el nombre");
	   int id = Integer.parseInt(sc.nextLine());
	   System.out.println("Dime el nuevo nombre");
	   String nombreNuevo = sc.nextLine();
	   
	   String SQL_UPDATE = " UPDATE producto SET nombre = ? WHERE id = ? ; ";
	   
	   try (PreparedStatement pstUpdate = conexion.prepareStatement(SQL_UPDATE);) {
		
		   pstUpdate.setString(1, nombreNuevo);
		   pstUpdate.setInt(2, id);
		   
		   int affectedRows = pstUpdate.executeUpdate();
		   if (affectedRows == 1) {
			System.out.println("Cambiado con exito!!!");
		}else {
			System.out.println("No se puede cambiar, seguro que existe el " + id + "?");
		}
	} //try
	   
	   
	   
	} catch (Exception e)
	{
		System.out.println("Lo sentimos pero eso nombre ya existe, ejecuta de nuevo y prueba suerte...");
	   e.printStackTrace();
	}

}
}
