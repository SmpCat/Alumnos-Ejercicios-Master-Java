package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.atrium.modelo.Fachada_Properties;
import com.atrium.vista.Formulario;

public class Controlador {

	public Controlador() {

		cargarLookAndFeel();
		instanciarFormularioPrincipal();
	}
	private void cargarLookAndFeel() {

		// CARGAR EL NUEVO LOOK AND FEEL SI SE PUEDE
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
				// USADA
				try {
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
				} catch (Exception e) {
				}
			}
		}
	}

	private void instanciarFormularioPrincipal() {
		
		Formulario formularioPrincipal = new Formulario();
	}
}
