package com.ipartek.formacion.modelo;

public class Producto {
	
	private int id;
	private String nombre;
	
	//constructor
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
	}


	public Producto(String nombre) {
		this();
		this.nombre = nombre;
	}

	//Getters and setters
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
		return "Producto [id=" + id + ", nombre=" + nombre + "]";
	} 
	
	
	
	
	

}
