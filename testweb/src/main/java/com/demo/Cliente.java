package com.demo;

import com.google.gson.annotations.SerializedName;

public class Cliente {

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@SerializedName("id")
	private int id;
	
	@SerializedName("nom")
	private String nombres;
	
	@SerializedName("ape")
	private String apellidos;
	
	
}
