package com.atrium.controlador;

import javax.swing.JFrame;

public class Ejercicio2 extends JFrame {

	/**
	 * Constructor de la clase.
	 */
	public Ejercicio2() {
		// POSICION Y TAMAÑO DE LA VENTANA
		setBounds(100, 100, 300, 450);
		// TITULO DE LA VENTANA
		setTitle("Ejercicio2");
		// IMPEDIMOS EL CAMBIO DE DE TAMAÑO
		setResizable(false);
		// MATAMOS EL PROGRAMA AL CERRAR LA VENTANA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ANULAMOS EL GESTOR DE CONTENIDOS (BORDERLAYOUT)
		// POSICIONAMIENTO MANUAL
		setLayout(null);
		// HACER VISIBLE LA VENTANA Y SU CONTENIDO
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Ejercicio2();
	}
}