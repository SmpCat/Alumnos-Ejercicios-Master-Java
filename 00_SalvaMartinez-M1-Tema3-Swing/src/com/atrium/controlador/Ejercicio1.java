package com.atrium.controlador;

import javax.swing.JFrame;

public class Ejercicio1 {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();

		// POSICION Y TAMA�O DE LA VENTANA
		ventana.setBounds(100, 100, 300, 450);
		// TITULO DE LA VENTANA
		ventana.setTitle("Ejercicio1");
		// IMPEDIMOS EL CAMBIO DE DE TAMA�O
		ventana.setResizable(false);
		// MATAMOS EL PROGRAMA AL CERRAR LA VENTANA
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ANULAMOS EL GESTOR DE CONTENIDOS (BORDERLAYOUT)
		// POSICIONAMIENTO MANUAL
		ventana.setLayout(null);
		// HACER VISIBLE LA VENTANA Y SU CONTENIDO
		ventana.setVisible(true);
	}
}