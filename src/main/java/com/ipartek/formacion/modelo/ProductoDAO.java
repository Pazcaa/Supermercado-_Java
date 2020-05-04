package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoDAO implements CrudAble<Producto> {
	
	private static ProductoDAO INSTANCE = null;
	
	private ProductoDAO() {
		super();
	}
	
	public static synchronized ProductoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
	}
	
	

	private final String SQL_GET_ALL = "SELECT id, nombre FROM producto ORDER BY id DESC;";
	
	public ArrayList<Producto> getAllByNombre(String nombre) {
		return null;
	}
	
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
	
	

	@Override
	public ArrayList<Producto> getAll() {
		ArrayList<Producto> registro = new ArrayList<Producto>();
		
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();){
		   
		   	System.out.println("Listado de Productos");
			System.out.println("---------------------------------------------");
		   
		
		   while (rs.next()) {
			   
			   int id = rs.getInt("id");
			   String nombre = rs.getString("nombre");
			   
			   Producto p = new Producto(nombre);
			   p.setId(id);
			   
			   //guardo cada producto con su id en el arraylist
			   registro.add(p);
			 }//while
		 
		} catch (Exception e){
		   
			e.printStackTrace();
		}
		return registro;
	}

	@Override
	public Producto getById(int id) throws Exception {
		//ArrayList<Producto> registro = new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);
				ResultSet rs = pst.executeQuery();
				Scanner sc = new Scanner(System.in);

		) {
			System.out.println("Dime nombre a buscar:");
			String nombreAbuscar = sc.nextLine();

			pst.setString(1, "%" + nombreAbuscar + "%");
			
				// consultar 1 a 1 los resultados, hasta que no existan mas registros
				while (rs.next()) {

					int id1 = rs.getInt("id");
					String nombre = rs.getString("nombre");

					Producto p = new Producto(nombre);
					p.setId(id1);

					//guardo cada producto con su id en el arraylist
					//   registro.add(p);
				} // while
			
		}catch (Exception e) {
			
			e.printStackTrace();

		}
		
		
		return Producto;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
