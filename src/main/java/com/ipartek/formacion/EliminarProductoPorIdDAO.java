package com.ipartek.formacion;


import java.util.Scanner;


import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOimpl;

public class EliminarProductoPorIdDAO {
public static void main(String[] args) {
	
	ProductoDAOimpl dao = ProductoDAOimpl.getInstance();
	
	System.out.println("Listado de Productos");
	System.out.println("----------------------------------------");
	
	for (Producto p : dao.getAll()) {
		System.out.println(p);
	}
	
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Dime el id para eliminar el producto");
		int id = Integer.parseInt(sc.nextLine());
		
		Producto pEliminado = dao.delete(id);
		System.out.println("Eliminado con exito " + pEliminado.getNombre());
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
}//main
}

