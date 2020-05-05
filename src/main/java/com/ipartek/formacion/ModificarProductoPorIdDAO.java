package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.log4j.pattern.IntegerPatternConverter;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

public class ModificarProductoPorIdDAO {
	public static void main(String[] args) {

		ProductoDAO dao = ProductoDAO.getInstance();

		System.out.println("Listado de Productos");
		System.out.println("----------------------------------------");

		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Dime el id para modificar el producto");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Dime el nuevo nombre del producto");
			String nombre = sc.nextLine();

			Producto p = new Producto();
			p.setId(id);
			p.setNombre(nombre);

			dao.update(p);
			System.out.println("Tu producto se ha modificado con exito");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}// main
}
