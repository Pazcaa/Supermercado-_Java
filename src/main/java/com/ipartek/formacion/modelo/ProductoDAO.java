package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase sirve para detallar los metodos para obtener, modificar, eliminar y actualizar la base de datos de MySQL.
 * 
 *
 * @see url github 
 * @author Paz Caamaño Barrera
 *
 */
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
	
	
//executeQUery => ResultSet
	private final String SQL_GET_ALL = "SELECT id, nombre FROM producto ORDER BY id DESC;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM producto WHERE id = ? ;";
	
	// excecuteUpdate => AffectedRows (numero de filas afectadas)
	private final String SQL_INSERT = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
	private String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; "; //si no escribo 'where id = ?' me cargo toda la lista!!!
	private String SQL_UPDATE = " UPDATE producto SET nombre = ? WHERE id = ? ; "; 
	
	
	public ArrayList<Producto> getAllByNombre(String nombre) {
		return null;
	}

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
		Producto registro = new Producto();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);
		) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
			}else {
				throw new Exception("No se pueden encontrar registro con igual id=" + id);
			} 
			
		}catch (Exception e) {
			
			e.printStackTrace();

		}
		
		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		//conseguir el listado de productos para saber cual eliminar
		Producto registro = getById(id);
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows != 1) {
				throw new Exception("No se pude eliminar el registro id=" + id);
			}
		}
	
		return registro;
	}

	
	@Override
	public Producto insert(Producto pojo) throws Exception {
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {
			
			pst.setString(1, pojo.getNombre());
			int AffectedRows = pst.executeUpdate();
			
			if (AffectedRows == 1) {
				//conseguir el ID que nos ha arrojado
				
				try(ResultSet rskeys = pst.getGeneratedKeys()){
					if (rskeys.next()) {
						int id = rskeys.getInt(0);
						pojo.setId(id);
					}
				}
				
			}else {
				throw new Exception("No se ha podido guardar el registro" + pojo); 
			}
			
		} catch (Exception e) {
			
		}
		
		return pojo;
	}

	@Override
	public Producto update(Producto pojo) throws Exception {
		
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}
		
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE)) {
			
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId()); 
			}
			
		} catch (SQLException e) { //excepcion mas especifica que "exception e"
			throw new Exception("El nombre " + pojo.getNombre() +" ya existe");
		}
		
		return pojo;
	}
	

}
