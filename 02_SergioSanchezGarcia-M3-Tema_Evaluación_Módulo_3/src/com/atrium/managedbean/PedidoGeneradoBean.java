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
@ManagedBean(name = "generadoBean")
@ViewScoped
public class PedidoGeneradoBean implements Serializable {

	/**
	 * Serial ID 
	 */
	private static final long serialVersionUID = 1L;

	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	
	
	/**
	 * Metodo para ir a Menu Inicio
	 * 
	 * @return
	 */
	public String irMenuInicio() {
		return rb.getString("pagina.menu");
	}
		
	
	/**
	 * Obtención del nombre de usuario guardado
	 * en la sesión.
	 */

	public String getnomUsu() {
		 Usuarios usuario = (Usuarios)Acceso_Contextos.getAtributo("usuario");
		 return usuario.getCodUsuario(); 
	}
	

}
