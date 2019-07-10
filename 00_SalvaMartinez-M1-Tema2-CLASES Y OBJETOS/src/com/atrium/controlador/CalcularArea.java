package com.atrium.controlador;

import com.atrium.modelo.*;
import com.atrium.vista.Vista;

public class CalcularArea {
	private int base;
	private int altura;
	private double radio;
	private static final double PI = 3.1416;
	private Vista vista;
	private Area rectangulo;
	private Area circulo;
	
	public CalcularArea () {
		vista = new Vista();
		rectangulo = new Area();
		circulo = new Area();
	}
	
	public void mostrarArea(String figura) {
		// PASO DE INFORMACION AL MODELO
	
		
		// PRUEBA METODOS VISTA
		if (figura == "rectángulo") {
			vista.mostrar_Texto("El area del rectángulo es " + rectangulo.calcularAreaRectangulo(5, 7));
		} else if (figura == "círculo") {
			vista.mostrar_Texto("El area del circulo es " + circulo.calcularAreaCirculo(2));
		}	
	}

}
