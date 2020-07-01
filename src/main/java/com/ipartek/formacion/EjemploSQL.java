package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class EjemploSQL {

	private final static String URL ="jdbc:mysql://localhost/supermercado";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection con =  DriverManager.getConnection (URL, USUARIO, PASS);
		
		System.out.println("1. Listado de todos los productos");
		System.out.println("----------------------------------------------------------------------------------");
		
		String sql = "SELECT id, nombre, precio FROM producto ORDER BY nombre ASC;";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " + rs.getFloat("precio"));
		}

		
		System.out.println(" ");
		System.out.println("2. Listar todas las columnas de la tabla producto");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT * FROM producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + 
								" " + rs.getInt(3) + " " + rs.getFloat(4) + 
								" " + rs.getString(5) + " " + rs.getInt(6));			
		}
	
		
		System.out.println(" ");
		System.out.println("3. Listar todos los nombre y precios de los productos, el nombre en mayuscula");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT UPPER(nombre), precio FROM producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("UPPER(nombre)") + " " + rs.getFloat("precio"));
		}
		
		System.out.println(" ");
		System.out.println("4. Listar todos los nombre y precios de los productos, redondeando el precio");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, ROUND(precio,1) FROM producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("nombre") + " " + rs.getFloat("ROUND(precio,1)"));
		}

		System.out.println(" ");
		System.out.println("5. Listar las categorias asociadas a los productos");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT DISTINCT(id_categoria) FROM producto ORDER BY id_categoria ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("id_categoria"));
		}
		
		System.out.println(" ");
		System.out.println("6. Listado de todos las categorias;");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT id , nombre  FROM categoria ORDER BY id ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
		}
		
		System.out.println(" ");
		System.out.println("7. listado de productos con nombre y ordenados por precio mas bajo");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto ORDER BY precio ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("nombre") + " " + rs.getFloat("precio"));
		}
		
		System.out.println(" ");
		System.out.println("8. listar productos que tengan el precio igual o mayor que 2.35€");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto WHERE precio >= 2.35 ORDER BY precio ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("nombre") + " " + rs.getFloat("precio"));
		}
		
		System.out.println(" ");
		System.out.println("9. todos los productos que en su nombre contengan la palabra 'patatas'");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT nombre FROM producto WHERE nombre LIKE '%patatas%' ORDER BY nombre DESC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("nombre"));
		}
		
		System.out.println(" ");
		System.out.println("10. listar todos los productos que tengan la palabra 'patatas' y que su precio sea superior a 2€");
		System.out.println("----------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto WHERE nombre LIKE '%patatas%' AND precio > 2 ORDER BY nombre DESC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("nombre") + " " + rs.getFloat("precio"));
		}
	}
}
