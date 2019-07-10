package com.atrium.controlador;

import java.text.DecimalFormat;

import com.atrium.modelo.Monedas;
import com.atrium.modelo.Persona;
import com.atrium.vista.Vista;

public class TestPersona {
	
	private Persona persona1, persona2, persona3;
	private Vista vista;
	
	public void gestionarPersonas() {
		persona1 = new Persona("Juan", 40);
		persona2 = new Persona("Pepe", 18);
		persona3 = new Persona("Carles", 50);
		vista = new Vista();
		
		vista.mostrar_Texto(persona1.calcularEdad());
		vista.mostrar_Texto(persona2.calcularEdad());
		vista.mostrar_Texto(persona3.calcularEdad());
	}
}
