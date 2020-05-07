package com.ipartek.formacion.modelo;

public class Usuario {
	
	private int id;
	private String nombre;
	private int contraseña;
	private int rol;
	
	//constructor
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contraseña = 0;
		this.rol = 0;
				
	}

	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getContraseña() {
		return contraseña;
	}

	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	//toString
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + ", rol=" + rol + "]";
	}
	
	
	
	
	

}
