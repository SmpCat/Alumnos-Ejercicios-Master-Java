package com.atrium.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio3 extends JFrame implements ActionListener {
	
	/**
	 * Constructor de la clase.
	 */
	public Ejercicio3() {
		
		// POSICION Y TAMAÑO DE LA VENTANA
		setBounds(100, 100, 300, 450);
		// TITULO DE LA VENTANA
		setTitle("Ejercicio3");
		// IMPEDIMOS EL CAMBIO DE DE TAMAÑO
		setResizable(false);
		// MATAMOS EL PROGRAMA AL CERRAR LA VENTANA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ANULAMOS EL GESTOR DE CONTENIDOS (BORDERLAYOUT)
		// POSICIONAMIENTO MANUAL
		setLayout(null);
		// CREACION DEL COMPONENTE
		crearInterface();
		// HACER VISIBLE LA VENTANA Y SU CONTENIDO
		setVisible(true);
	}
	
	private void crearInterface() {
		
		// CREAR BOTON
		JButton boton = new JButton("Salir");
		boton.setBounds(50, 200, 180, 20);
		add(boton);
		//ASOCIACION DE EMISOR (BOTON) CON RECEPTOR (VENTANA)
		boton.addActionListener(this);
	}
	
	/**
	 * Tratamiento de eventos de boton.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		System.exit(0);
	}
	
	public static void main(String args[]) {
		new Ejercicio3();
	}
	
}