package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAOimpl implements UsuarioDAO{

	//singleton
	private static UsuarioDAOimpl INSTANCE = null;

	// constructor del INSTANCE
	public UsuarioDAOimpl() {
		super();
	}
	//metodo del INSTANCE
	public static synchronized UsuarioDAOimpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOimpl();
		}
		
		return INSTANCE;
	}
	
	//executeQUery => ResultSet
			private final String SQL_GET_ALL = "SELECT id, nombre FROM usuario ORDER BY id DESC;";
			private final String SQL_GET_BY_ID = "SELECT id, nombre FROM usuario WHERE id = ? ;";
			private final String SQL_GET_BY_NAME = "SELECT id, nombre FROM usuario WHERE nombre LIKE ? ;";
			
			// excecuteUpdate => AffectedRows (numero de filas afectadas)
			private final String SQL_INSERT = "INSERT INTO usuario (nombre, contrasenia, id_rol) VALUES ( ? , 123456, 1); ";
			private String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; "; //si no escribo 'where id = ?' me cargo toda la lista!!!
			private String SQL_UPDATE = " UPDATE usuario SET nombre = ? WHERE id = ? ; "; 
	
//metodos del CRUD y del UsuarioDAO

	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> registro = new ArrayList<Usuario>();
		
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();){
		   
		
		   
		
		   while (rs.next()) {
			   
			   int id = rs.getInt("id");
			   String nombre = rs.getString("nombre");
			   
			 
			   
			   Usuario u = new Usuario();
			   u.setId(id);
			   u.setNombre(nombre);
			  
			   
			   
			   //guardo cada producto con su id en el arraylist
			   registro.add(u);
			 }//while
		 
		} catch (Exception e){
		   
			e.printStackTrace();
		}
		return registro;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		Usuario registro = new Usuario();
		
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
	public Usuario delete(int id) throws Exception {
		//conseguir el listado de productos para saber cual eliminar
				Usuario registro = getById(id);
				
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
	public Usuario insert(Usuario pojo) throws Exception {
		try(
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {
			
			//TODO no funciona el agregar nuevo usuario
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
	public Usuario update(Usuario pojo) throws Exception {
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

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		ArrayList<Usuario> registro = new ArrayList<Usuario>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NAME);	
				
	) {

		
				pst.setString(1, "%" + palabraBuscada + "%");
				
				try(ResultSet rs = pst.executeQuery();){
			
				// consultar 1 a 1 los resultados, hasta que no existan mas registros
				while (rs.next()) {

					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");

					Usuario u = new Usuario();
					u.setId(id);
					u.setNombre(nombre);

					registro.add(u);
					

				} // while
				}
			

		

		} catch (Exception e) {
			
			e.printStackTrace();

		}
		return registro;
	}
	
}
