package com.atrium.controlador;

import com.atrium.modelo.*;
import com.atrium.vista.Vista;

public class Controlador {
	// PROPIEDADES DE CLASE
	private Vista vista;
	private Saludo saludo;
	private TestAnimal testAnimal;
	private CalcularArea calcularArea;

	/**
	 * Constructor sin argumentos.
	 */
	public Controlador() {
		// INSTANCIA DE PROPIEDADES DE CLASE
		vista = new Vista();
		saludo = new Saludo();
		testAnimal = new TestAnimal();
		calcularArea = new CalcularArea();
		
		// LLAMADA A METODO DE ACCION
		ejecutarSaludo();
		testAnimal.mostrarAnimal();
		calcularArea.mostrarArea("rectángulo");
		calcularArea.mostrarArea("círculo");
	}

	/**
	 * Proceso de control de flujo en el programa.
	 */
	public void ejecutarSaludo() {
		// PASO DE INFORMACION AL MODELO
		saludo.setTexto("Bienvenid@");
		
		
		// PRUEBA METODOS VISTA
		vista.mostrar_Texto(saludo.getTexto());
	}
}
