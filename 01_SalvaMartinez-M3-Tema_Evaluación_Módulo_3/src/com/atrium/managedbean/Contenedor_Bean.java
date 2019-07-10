package com.atrium.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.ace.event.AccordionPaneChangeEvent;
import org.icefaces.ace.event.CloseEvent;
import org.icefaces.ace.event.ToggleEvent;

/**
 * Soporte del ejemplo de contenedores.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-5-2017.
 * 
 */
@ManagedBean(name = "contenedor_bean")
@ViewScoped
public class Contenedor_Bean {

	// PROPIEDADES DE CLASE
	// VISIBILIDAD/ESTADO DEL COMPONENTE ACE:DIALOG
	private boolean dialogo_visible;
	// VISIBILIDAD/ESTADO DEL COMPONENTE ACE:NOTIFICATION
	private boolean notificacion_visible;

	public Contenedor_Bean() {
		dialogo_visible = true;
		notificacion_visible = true;
	}

	// *********** EVENTOS ACE:PANEL
	/**
	 * Tratamiento de evento de cierre del ACE:PANEL
	 * 
	 * @param evento
	 */
	public void evento_CierrePanel(CloseEvent evento) {
		System.out.println("Soy el evento de cierre de la ventana");
	}

	/**
	 * Tratamiento de evento de repliege del ACE:PANEL
	 * 
	 * @param evento
	 */
	public void evento_RepliegePanel(ToggleEvent evento) {
		System.out.println("Soy el evento de repliege de la ventana");
	}

	// *********** EVENTOS ACE:TABSET
	/**
	 * Tratamiento de evento de cambio de pestaña en el ACE:TABSET<br/>
	 * El lanzamiento es automatico si se trabaja en el lado del servidor, en
	 * caso contrario a que activarlo mediante el componente de ace:ajax.
	 * 
	 * @param evento
	 */
	public void evento_CambioPestaña(ValueChangeEvent evento) {
		System.out.println("Soy el evento de cambio de pestaña en el servidor");
	}

	/**
	 * Tratamiento de evento de cambio de pestaña trabajando en el cliente.<br/>
	 * El evento es un generico definido en el ace:ajax.
	 * 
	 * @param evento
	 */
	public void evento_CambioPestañaCliente(AjaxBehaviorEvent evento) {
		System.out.println("Soy el evento de cambio de pestaña en el cliente");
	}

	// *********** EVENTOS ACE:ACCORDION
	/**
	 * Tratamiento de evento de apertura de acordeon.<br/>
	 * 
	 * @param evento
	 */
	public void evento_CambioAcordeon(AccordionPaneChangeEvent evento) {
		System.out.println("Soy el evento de cambio en el acordeon.");
	}

	// *********** EVENTOS ACE:DIALOG
	/**
	 * Tratamiento de evento de cierre del ACE:DIALOG
	 * 
	 * @param evento
	 */
	public void evento_CierreDialogo(CloseEvent evento) {
		dialogo_visible = false;
		System.out
				.println("Soy el evento de cierre de la ventana modal via boton cierre");
	}

	// *********** EVENTOS ACE:NOTIFICATIONPANEL
	/**
	 * Tratamiento de apertura de contenedor notificacionpanel.
	 * 
	 * @param evento
	 */
	public void evento_MostrarPanelNotificacion(AjaxBehaviorEvent evento) {
		notificacion_visible = true;
		System.out.println("Soy el evento de apertura del notificationpanel");
	}

	/**
	 * Tratamiento de cierre de contenedor notificacionpanel.
	 * 
	 * @param evento
	 */
	public void evento_CerrarPanelNotificacion(AjaxBehaviorEvent evento) {
		notificacion_visible = false;
		System.out.println("Soy el evento de cierre del notificationpanel");
	}

	// *********** EVENTO ACE:TOOLTIP
	/**
	 * Tratamiento del evento de mostrar la ayuda en el cliente.
	 * 
	 * @param evento
	 */
	public void evento_MostrarToolTip(AjaxBehaviorEvent evento) {
		System.out.println("Soy el evento de mostrar ToolTip");
	}

	// ACCESORES PARA LOS CONTENEDORES DE ACE
	public boolean isDialogo_visible() {
		return dialogo_visible;
	}

	public void setDialogo_visible(boolean dialogo_visible) {
		this.dialogo_visible = dialogo_visible;
	}

	public boolean isNotificacion_visible() {
		return notificacion_visible;
	}

	public void setNotificacion_visible(boolean notificacion_visible) {
		this.notificacion_visible = notificacion_visible;
	}

}
