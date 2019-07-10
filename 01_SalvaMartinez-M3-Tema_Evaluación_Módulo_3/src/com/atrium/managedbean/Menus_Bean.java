package com.atrium.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 * Managedbean para el soporte del ejemplo de los menus.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-5-2017.
 * 
 */
@ManagedBean(name = "prueba_menu")
@ViewScoped
public class Menus_Bean implements Serializable {
	
	// PROPIEDADES DE CLASE
	// VISIBILIDAD/ESTADO DEL COMPONENTE ACE:PANEL
	private boolean panel_visible;

	public Menus_Bean() {
		panel_visible = false;
	}
	
	// ************ EVENTO ACE:MENUITEM
	/**
	 * Evento producido por el usuario al seleccionar un menuitem de cualquier
	 * menu.
	 * 
	 * @param evento
	 *            {@link ActionEvent}
	 */
	public void evento_Menu(ActionEvent evento) {
		String opcion_seleccionada = evento.getComponent().getId();
		
		switch (opcion_seleccionada) {
		case "op11h":
			this.panel_visible = true;
			break;
		case "op21h":
			this.panel_visible = false;
			break;
		default:
			break;
		}
	}
	
	public boolean isPanel_visible() {
		return panel_visible;
	}

	public void setPanel_visible(boolean panel_visible) {
		this.panel_visible = panel_visible;
	}

}
