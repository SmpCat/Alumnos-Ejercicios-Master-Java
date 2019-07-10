package com.atrium.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Ejercicios extends JFrame implements ActionListener {

	/**
	 * Constructor de la clase.
	 */
	public Ejercicios() {

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

		// CONTENEDOR DEL MENU
		JMenuBar barra_menu = new JMenuBar();
		// CREAMOS LAS OPCIONES DE LA BARRA DE MENU
		JMenu opcion1 = new JMenu("Archivo");
		JMenu opcion2 = new JMenu("Clientes");
		JMenu opcion3 = new JMenu("Ayuda");
		// CREAMOS EL CONTENIDO DE LAS OPCIONES DEL MENU
		JMenuItem opcion11 = new JMenuItem("Abrir");
		JMenuItem opcion12 = new JMenuItem("Cerrar");
		JMenuItem opcion13 = new JMenuItem("Salir");
		JMenuItem opcion21 = new JMenuItem("Gestion");
		JMenuItem opcion22 = new JMenuItem("Facturar");
		JMenuItem opcion31 = new JMenuItem("Ayuda");
		JMenuItem opcion32 = new JMenuItem("Acerca de...");
		// CREAMOS EL SUBMENU
		JMenu submenu = new JMenu("submenu");
		JMenuItem submenu1 = new JMenuItem("opcion 1 submenu");
		JMenuItem submenu2 = new JMenuItem("opcion 2 submenu");
		// PONEMOS EL CONTENEDOR DEL MENU EN LA VENTANA
		setJMenuBar(barra_menu);
		// CREAMOS EL BOTON
		JButton boton = new JButton("Salir");
		boton.setBounds(50, 200, 180, 20);
		// AÑADIMOS LAS OPCIONES DEL MENU AL CONTENEDOR
		barra_menu.add(opcion1);
		barra_menu.add(opcion2);
		barra_menu.add(opcion3);
		// PONEMOS EL CONTENIDO DE CADA OPCION DE MENU
		opcion1.add(opcion11);
		opcion1.add(opcion12);
		opcion1.add(opcion13);
		opcion2.add(opcion21);
		opcion2.add(opcion22);
		opcion3.add(opcion31);
		opcion3.add(opcion32);
		// MONTAMOS EL SUBMENU DENTRO DEL MENU DE AYUDA
		opcion3.addSeparator();
		opcion3.add(submenu);
		submenu.add(submenu1);
		submenu.add(submenu2);
		// AÑADIMOS EL BOTON AL JFRAME
		add(boton);
		
		// ASOCIAMOS EL ESCUCHADOR DE EVENTOS CON EL COMPONENTE
		opcion11.addActionListener(this);
		opcion12.addActionListener(this);
		opcion13.addActionListener(this);
		opcion21.addActionListener(this);
		opcion22.addActionListener(this);
		opcion31.addActionListener(this);
		opcion32.addActionListener(this);
		// ASOCIAMOS TAMBIEN EL SUBMENU AL MISMO RECEPTOR
		submenu1.addActionListener(this);
		submenu2.addActionListener(this);
		//ASOCIACION DE EMISOR (BOTON) AL MISMO RECEPTOR
		boton.addActionListener(this);

		// DAMOS VALOR A LA PROPIEDAD NAME PARA IDENTIFICAR LOS OBJETOS EN EL
		// EVENTO
		opcion11.setName("opcion11");
		opcion12.setName("opcion12");
		opcion13.setName("opcion13");
		opcion21.setName("opcion21");
		opcion22.setName("opcion22");
		opcion31.setName("opcion31");
		opcion32.setName("opcion32");
		// TRATAMIENTO DEL SUBMENU
		submenu1.setName("submenu1");
		submenu2.setName("submenu2");
		// TRATAMIENTO DEL BOTON
		boton.setName("boton");
		
		// AÑADIMOS A LA OPCION SALIR UN ACELERADOR DE TECLADO
		opcion13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK + InputEvent.ALT_MASK));
		// CAMBIO DE FUENTE
		opcion32.setFont(new Font("Times New Roman", Font.BOLD, 20));
		// CAMBIO DE COLOR
		opcion32.setForeground(Color.BLACK);
	}

	/**
	 * Tratamiento del evento de los jmenuitem.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String opcion_seleccionada = ((JComponent) evento.getSource()).getName();
		// LOGICA PARA DETERMINAR EL JMENUITEM SELECCIONADO
		if (opcion_seleccionada.equals("opcion11")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion12")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion13")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
			System.exit(0);
		}
		if (opcion_seleccionada.equals("opcion21")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion22")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion31")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion32")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("submenu1")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("submenu2")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("boton")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
			System.exit(0);
		}
	}
	public static void main(String args[]) {
		new Ejercicios();
	}
}