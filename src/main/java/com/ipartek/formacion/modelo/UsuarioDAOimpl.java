package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAOimpl implements UsuarioDAO {

	// singleton
	private static UsuarioDAOimpl INSTANCE = null;

	// constructor del INSTANCE
	public UsuarioDAOimpl() {
		super();
	}

	// metodo del INSTANCE
	public static synchronized UsuarioDAOimpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOimpl();
		}

		return INSTANCE;
	}

	// executeQUery => ResultSet
	private final String SQL_GET_ALL 		= "SELECT id, nombre, contrasenia, id_rol FROM usuario ORDER BY id DESC;";
	private final String SQL_GET_BY_ID 		= "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE id = ? ;";
	private final String SQL_GET_BY_NAME 	= "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre LIKE ? ;";
	private final String SQL_EXISTE 		= "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre = ? AND contrasenia = ? ; ";

	// excecuteUpdate => AffectedRows (numero de filas afectadas)
	private final String SQL_INSERT = "INSERT INTO usuario (nombre, contrasenia, id_rol) VALUES ( ? ,?, ?); ";
	private final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; "; // si no escribo 'where id = ?' me cargo toda la lista!!!
	private final String SQL_UPDATE = " UPDATE usuario SET nombre = ? WHERE id = ? ; ";

//metodos del CRUD y del UsuarioDAO

	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				// guardo cada producto con su id en el arraylist
				usuarios.add(mapper(rs));
			} // while

		} catch (Exception e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		Usuario usuario = new Usuario();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					usuario = mapper(rs);
				} else {
					throw new Exception("No se pueden encontrar registro con igual id=" + id);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return usuario;

	}

	@Override
	public Usuario delete(int id) throws Exception {
		// conseguir el listado de productos para saber cual eliminar
		Usuario usuario = getById(id);

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				throw new Exception("No se pude eliminar el registro id=" + id);
			}
		}

		return usuario;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setInt(3, pojo.getIdRol());
			
			int AffectedRows = pst.executeUpdate();
			if (AffectedRows == 1) {
				// conseguir el ID que nos ha arrojado

				try (ResultSet rskeys = pst.getGeneratedKeys()) {
					if (rskeys.next()) {
						int id = rskeys.getInt(1);
						pojo.setId(id);
					}
				}

			} else {
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

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId());
			}

		} catch (SQLException e) { // excepcion mas especifica que "exception e"
			throw new Exception("El usuario " + pojo.getNombre() + " ya existe");
		}

		return pojo;
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NAME);

		) {

			pst.setString(1, "%" + palabraBuscada + "%");

			try (ResultSet rs = pst.executeQuery();) {

				// consultar 1 a 1 los resultados, hasta que no existan mas registros
				while (rs.next()) {

					usuario.add(mapper(rs));

				} // while
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return usuario;
	}

	@Override
	public Usuario existe(String nombre, String password) {
		
		Usuario usuario = null;

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);) {

			pst.setString(1, nombre);
			pst.setString(2, password);
			
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					usuario = mapper(rs);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return usuario;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(rs.getString("nombre"));
		usuario.setId(rs.getInt("id"));
		usuario.setIdRol(rs.getInt("id_rol"));
		usuario.setContrasenia("contrasenia");
		
		
		return usuario;
	}
}
