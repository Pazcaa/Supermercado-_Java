package com.ipartek.formacion.modelo;

public class Usuario {
	
	private int id;
	private String nombre;

	
	//constructor
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		
				
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


	//toString
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}


}
