package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RolDAOimpl implements RolDAO{

	//singleton
		private static UsuarioDAOimpl INSTANCE = null;
		
		
	//constructor
	public RolDAOimpl() {
			super();
		}
	
	public static synchronized UsuarioDAOimpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOimpl();
		}
		
		return INSTANCE;
	}
	
	//executeQUery => ResultSet
	private final String SQL_GET_ALL = "SELECT id, nombre FROM rol ORDER BY id DESC;";
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM rol WHERE id = ? ;";
	private final String SQL_GET_BY_NAME = "SELECT id, nombre FROM rol WHERE nombre LIKE ? ;";
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol insert(Rol pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol update(Rol pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rol> getAllByNombre(String palabraBuscada) {
		// TODO Auto-generated method stub
		return null;
	}

}
