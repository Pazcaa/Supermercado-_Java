package com.ipartek.formacion.modelo;

public class Rol {

	private int id;
	private String nombre;
	
	//constructor
	public Rol() {
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
