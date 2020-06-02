package com.ipartek.formacion.controller;

public class Alerta {
	
	private String tipo;
	private String texto;
	
	//contructor
	public Alerta() {
		super();
		this.texto = "";
		this.tipo = "";
	}
	public Alerta(String tipo, String texto) {
		this();
		this.tipo = tipo;
		this.texto = texto;
	}
	
	//getters & setters
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	//toString
	@Override
	public String toString() {
		return "Alerta [tipo=" + tipo + ", texto=" + texto + "]";
	}

}
