package com.atrium.modelo;

public class Animal {
	
	private String especie;
	
	//Constructores
	
	public Animal() {
	
	}
	
	public Animal(String especie) {
		this.especie = especie;
	}
	
	//Getters y Setters
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
}