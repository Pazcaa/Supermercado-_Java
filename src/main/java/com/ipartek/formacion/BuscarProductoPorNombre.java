package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscarProductoPorNombre {
public static void main(String[] args) {
	
	final String SQL = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
	Connection conexion = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	
	// String nombre = "galle";
		// pst.setString( 1, "%" + nombre + "%")
	
}
}
