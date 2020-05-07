package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOimpl;

/**
 * Poder ver todos los alumnos, crear nuevos, eliminar, editar y buscar por nombre
 * @author javaee
 *
 */

public class GestionUsuarios {

	public static void main(String[] args) {
	
		try (Scanner sc = new Scanner(System.in);){
			
			System.out.println("Menu de Opciones");
			System.out.println("------------------------------------------------------------");
			System.out.println("1. Listado de Usuarios");
			System.out.println("2. Buscar Usuario por id");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Insertar Usuario");
			System.out.println("5. Modificar Usuario");
			System.out.println("6. Buscar Usuario por nombre");
			System.out.println("7. Cerrar el programa");
			
			System.out.println("------------------------------------------------------------");
			
			
			
			boolean continuar = false;
			
			
			do {
				
				System.out.println("Por favor digite el numero de la accion que desea realizar");
				int opcion = Integer.parseInt(sc.nextLine());
				
				UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
				
				switch (opcion) {
				case 1:
					
					//UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
				
					
					ArrayList<Usuario> usuarios = dao.getAll();
					
					System.out.println("Listado de Usuario");
					System.out.println("---------------------------------------------");
					
					for (Usuario u : usuarios) {
						System.out.println(u);
					}
					
					continuar = true;
					
					break;
				case 2:
					System.out.println("Buscar Usuario por id");
					System.out.println("---------------------------------------------");
					
					//UsuarioDAOimpl dao = UsuarioDAOimpl.getInstance();
					
					System.out.println("Listado de Usuario");
					System.out.println("---------------------------------------------");
					
					for (Usuario u : dao.getAll()) {
						System.out.println(u);
					}
					
					try{
						
						System.out.println("Dime el id del usuario que desea");
						int id = Integer.parseInt(sc.nextLine());
						
						Usuario u = dao.getById(id);
						System.out.println(u);
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					continuar = true;
					break;
					
				case 3:
					System.out.println("Eliminar Usuario");
					System.out.println("---------------------------------------------");
					
					System.out.println("Listado de Usuarios");
					System.out.println("----------------------------------------");
					
					for (Usuario u : dao.getAll()) {
						System.out.println(u);
					}
					
					try {
						System.out.println("Dime el id para eliminar el producto");
						int id = Integer.parseInt(sc.nextLine());
						
						Usuario uEliminado = dao.delete(id);
						System.out.println("Eliminado con exito " + uEliminado.getNombre());
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					
					continuar = true;
					break;
					
				case 4: //TODO no ingresa nuevo usuarios
					System.out.println("Insertar Usuario");
					System.out.println("---------------------------------------------");
					
					boolean continuar1 = true;
					
					try {
					
					   do {
						 
							try {
								
								  System.out.println("dime un nuevo usuario a guardar");
								   String nombre = sc.nextLine();
								   Usuario u = new Usuario();
								   u.setNombre(nombre);
								   
								   u = dao.insert(u);
								   continuar1 = false;
								   
								
							} catch (Exception e) {
								System.out.println("Lo sentimos pero el usuario ya existe, dime otro");
							} 
					   
						
					} while (continuar1);
					
					} catch (Exception e) {
						System.out.println("Tenemos un problema " + e.getMessage());
					}
					
					continuar = true;
					break;
					
				case 5:
					System.out.println("Modificar Usuario");
					System.out.println("---------------------------------------------");
					
					System.out.println("Listado de Usuarios");
					System.out.println("----------------------------------------");

					for (Usuario u : dao.getAll()) {
						System.out.println(u);
					}

					try {
						System.out.println("Dime el id para modificar el producto");
						int id = Integer.parseInt(sc.nextLine());

						System.out.println("Dime el nuevo nombre del producto");
						String nombre = sc.nextLine();

						Usuario u = new Usuario();
						u.setId(id);
						u.setNombre(nombre);

						dao.update(u);
						System.out.println("Tu lista se ha modificado con exito");

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					continuar = true;
					break;
					
				case 6:
					System.out.println("Buscar Usuario por nombre");
					System.out.println("---------------------------------------------");
					
					continuar = true;
					break;
					
				case 7:
					System.out.println("Cerrar el programa");
					System.out.println("---------------------------------------------");
					
					System.out.println("Hasta Pronto!!!");
					
					continuar = false;
					break;
					

				default:
					break;
				}
				
			} while (continuar);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	
		
		
	
	}

}
