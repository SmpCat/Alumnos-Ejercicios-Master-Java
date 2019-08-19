package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.atrium.hibernate.Usuarios;
import com.atrium.util.Acceso_Contextos;

/**
 * Menu inicial tras el login de la aplicación 
 * 
 * @author Sergio Sánchez García.
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
	 * Metodo para ir a la Gestión de Pedidos 
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
	 * Metodo para ir a la creación de nuevo Pedido
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
	 * Obtención del nombre de usuario guardado
	 * en la sesión.
	 */

	public String getnomUsu() {
		 Usuarios usuario = (Usuarios)Acceso_Contextos.getAtributo("usuario");
		 return usuario.getCodUsuario(); 
	}
	

	
	/**
	 * Desconexión del logado
	 * @return 
	 */	
	public String desconexion() {
		Acceso_Contextos.desconexion();
		return rb.getString("pagina.login");
	}

}
