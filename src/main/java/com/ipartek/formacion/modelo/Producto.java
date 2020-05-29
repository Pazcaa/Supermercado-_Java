package com.ipartek.formacion.modelo;

public class Producto {
	
	private int id;
	private String nombre;
	private float precio;
	private String imagen; 
	
	//constructor
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "";
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


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen + "]";
	} 
	
	
	
	
	

}
