package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Rol;
import com.ipartek.formacion.modelo.RolDAOimpl;


public class GestionRol {
	
	static RolDAOimpl dao = RolDAOimpl.getInstance();
	static boolean continuar = false;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		

		
		
		
		try {
			
			System.out.println("Menu de Opciones");
			System.out.println("------------------------------------------------------------");
			System.out.println("1. Listado de Usuarios");
			System.out.println("2. Buscar Usuario por id");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Insertar Usuario");
			System.out.println("5. Modificar Usuario");
			System.out.println("6. Cerrar el programa");
			
			System.out.println("------------------------------------------------------------");
			
			
			do {
				
				System.out.println("Por favor digite el numero de la accion que desea realizar");
				int opcion = Integer.parseInt(sc.nextLine());
				
				
				switch (opcion) {
				case 1: 
					listar();
					
					break;
				case 2:
					buscar_id();
					
					break;
					
				case 3:
					eliminar();
					
					break;
					
				case 4: 
					insertar();
					
					break;
					
				case 5:
					modificar();
					
					break;
					
						
				case 6:
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
			System.out.println(e.getMessage());
		}
		
	}


	private static void listar() {
		ArrayList<Rol> rol = dao.getAll();
		
		System.out.println("Listado de Rol");
		System.out.println("---------------------------------------------");
		
		for (Rol r : rol) {
			System.out.println(r);
		}
		
		continuar = true;
		
	}
	
	private static void buscar_id() {
		System.out.println("Buscar Rol por id");
		System.out.println("---------------------------------------------");
		
		
		System.out.println("Listado de Rol");
		System.out.println("---------------------------------------------");
		
		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}
		
		try{
			
			System.out.println("Dime el id del rol que desea");
			int id = Integer.parseInt(sc.nextLine());
			
			Rol r = dao.getById(id);
			System.out.println(r);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		continuar = true;
		
	}

	
	private static void eliminar() {
		System.out.println("Eliminar Rol");
		System.out.println("---------------------------------------------");
		
		System.out.println("Listado de Rol");
		System.out.println("----------------------------------------");
		
		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}
		
		try {
			System.out.println("Dime el id para eliminar el rol");
			int id = Integer.parseInt(sc.nextLine());
			
			Rol rEliminado = dao.delete(id);
			System.out.println("Eliminado con exito " + rEliminado.getNombre());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		continuar = true;
		
	}
	
	private static void insertar() {
		System.out.println("Insertar Rol");
		System.out.println("---------------------------------------------");
		
		boolean continuar1 = true;
		
		try {
		
		   do {
			 
				try {
					
					  System.out.println("dime un nuevo rol a guardar");
					   String nombre = sc.nextLine();
					   Rol r = new Rol();
					   r.setNombre(nombre);
					   
					   r = dao.insert(r);
					   continuar1 = false;
					   
					
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el rol ya existe, dime otro");
				} 
		   
			
		} while (continuar1);
		
		} catch (Exception e) {
			System.out.println("Tenemos un problema " + e.getMessage());
		}
		
		continuar = true;
		
	}
	
	private static void modificar() {
		System.out.println("Modificar Rol");
		System.out.println("---------------------------------------------");
		
		System.out.println("Listado de Rol");
		System.out.println("----------------------------------------");

		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}

		try {
			System.out.println("Dime el id para modificar el rol");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Dime el nuevo nombre del rol");
			String nombre = sc.nextLine();

			Rol r = new Rol();
			r.setId(id);
			r.setNombre(nombre);

			dao.update(r);
			System.out.println("Tu lista se ha modificado con exito");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		continuar = true;
	}
	

	}//class



