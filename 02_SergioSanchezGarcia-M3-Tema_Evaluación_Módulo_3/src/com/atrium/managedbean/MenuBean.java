package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.atrium.hibernate.Usuarios;
import com.atrium.util.Acceso_Contextos;

/**
 * Menu inicial tras el login de la aplicaci�n 
 * 
 * @author Sergio S�nchez Garc�a.
 * @version 1.0.
 * @since 01-07-2019.
 * 
 */
@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean implements Serializable {

	/**
	 * Serial ID 
	 */
	private static final long serialVersionUID = 1L;
	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	
	
	/**
	 * Metodo para ir a la Gesti�n de Pedidos 
	 * 
	 * @return
	 */
	public String irGestionPedidos() {
		if (null != Acceso_Contextos.getAtributo("usuario")) {
			return rb.getString("pagina.gestionPedido");
		} else {
			return rb.getString("pagina.login");
		}
	}
	
	/**
	 * Metodo para ir a la creaci�n de nuevo Pedido
	 * 
	 * @return
	 */
	public String irNuevoPedido() {
		if (null != Acceso_Contextos.getAtributo("usuario")) {
			return rb.getString("pagina.nuevoPedido");
		} else {
			return rb.getString("pagina.login");
		}
	}
	
	
	
	/**
	 * Obtenci�n del nombre de usuario guardado
	 * en la sesi�n.
	 */

	public String getnomUsu() {
		 Usuarios usuario = (Usuarios)Acceso_Contextos.getAtributo("usuario");
		 return usuario.getCodUsuario(); 
	}
	

	
	/**
	 * Desconexi�n del logado
	 * @return 
	 */	
	public String desconexion() {
		Acceso_Contextos.desconexion();
		return rb.getString("pagina.login");
	}

}
