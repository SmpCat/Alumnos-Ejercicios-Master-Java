package com.atrium.controlador;

import com.atrium.modelo.*;
import com.atrium.vista.Vista;

public class TestAnimal {

	private Vista vista;
	private Animal perro;
	private Animal pez;
	private Animal cocodrilo;

	public TestAnimal() {
		vista = new Vista();
		perro = new Animal();
		pez = new Animal();
		cocodrilo = new Animal();
	}
	
	public void mostrarAnimal() {
		// PASO DE INFORMACION AL MODELO
		perro.setEspecie("perro");
		pez.setEspecie("pez");
		cocodrilo.setEspecie("cocodrilo");
		
		// PRUEBA METODOS VISTA
		vista.mostrar_Texto("Soy un " + perro.getEspecie());
		vista.mostrar_Texto("Soy un " + pez.getEspecie());
		vista.mostrar_Texto("Soy un " + cocodrilo.getEspecie());
	}
}
