package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDAOimpl implements RolDAO{

	//singleton
		private static RolDAOimpl INSTANCE = null;
		
		
	//constructor
	public RolDAOimpl() {
			super();
		}
	
	public static synchronized RolDAOimpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAOimpl();
		}
		
		return INSTANCE;
	}
	
	//executeQUery => ResultSet
	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ? ;";
	
	// excecuteUpdate => AffectedRows (numero de filas afectadas)
	private final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?); ";
	private String SQL_DELETE = " DELETE FROM rol WHERE id = ? ; "; //si no escribo 'where id = ?' me cargo toda la lista!!!
	private String SQL_UPDATE = " UPDATE rol SET nombre = ? WHERE id = ? ; "; 
	
	
	
	//metodos del CRUD y del RolDAO
	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> registro = new ArrayList<Rol>();
		
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();){
		   
		   while (rs.next()) {
			   
			   int id = rs.getInt("id");
			   String nombre = rs.getString("nombre");
			   
			   Rol r = new Rol();
			   r.setId(id);
			   r.setNombre(nombre);
			  
			   //guardo cada producto con su id en el arraylist
			   registro.add(r);
			 }//while
		 
		} catch (Exception e){
		   
			e.printStackTrace();
		}
		return registro;
	}
	

	@Override
	public Rol getById(int id) throws Exception {
		Rol registro = new Rol();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);
		) {

			pst.setInt(1, id);
			try(ResultSet rs = pst.executeQuery();){
			
			if (rs.next()) {
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
			}else {
				throw new Exception("No se pueden encontrar registro con igual id=" + id);
			} 
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();

		}
		
		return registro;
	}

	@Override
	public Rol delete(int id) throws Exception {
		//conseguir el listado de productos para saber cual eliminar
		Rol registro = getById(id);
		
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
	public Rol insert(Rol pojo) throws Exception {
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
	public Rol update(Rol pojo) throws Exception {
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
			throw new Exception("El usuario " + pojo.getNombre() +" ya existe");
		}
		
		return pojo;
	}



}
