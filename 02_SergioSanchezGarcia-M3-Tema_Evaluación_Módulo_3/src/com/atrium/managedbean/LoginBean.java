package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.util.Acceso_Contextos;
import com.atrium.util.Ejecucion_Expresiones;

@ManagedBean(name = "login_bean")
@ViewScoped
public class LoginBean implements Serializable {
	/**
	 * SerialVersion 
	 */
	private static final long serialVersionUID = 1L;
	// PROPIEDADES PARA RECIBIR LOS VALORES DE LOS COMPONENTES
	private String nombre;
	private String clave;
	// FACHADA DE LA CAPA MODELO
	@ManagedProperty("#{gestion_usuario}")
	private IGestion_Usuario gestion_usuario;
	// CONTROL DE NAVEGACION
	private Boolean salida;
	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	
	
	public LoginBean() {
		salida = Boolean.FALSE;
	}

	
	/**
	 * Metodo de registro de Usuario
	 * 
	 * @return
	 */
	public String registroUsuario() {
			return rb.getString("pagina.registro");
	}
	
	
	/**
	 * Metodo de comprobación credenciales
	 * 
	 * @return
	 */
	public String comprobar_Credenciales() {
		if (salida) {
			return rb.getString("pagina.menu");
		} else {
			return "";
		}
	}

	/**
	 * Metodo de evento de comprobación de credenciales. 
	 */
	public void evento_ComprobarCredenciales(ActionEvent evento) {
		// Usuarios usuario = gestion_usuarios.consultar_PorNombre(getNombre());
		Usuarios usuario = Ejecucion_Expresiones.tratar_Expresion(
				"#{gestion_usuario}", IGestion_Usuario.class)
				.consultar_PorNombre(getNombre());

		if (usuario != null) {
			if (usuario.getPassword().equals(getClave())) {
				// CREDENCIALES CORRECTAS
				// NAVEGACION A LA SIGUIENTE VISTA
				salida = Boolean.TRUE;
				// GUARDAMOS EL PERFIL DE USUARIO EN LA SESION
				Acceso_Contextos.setAtributo("usuario", usuario);
			} else {
				// ERROR EN LA CLAVE -- OPCION IDIOMATIZADA
				// RECORDAR QUE EL IDENTIFICADOR DEBE IR CUALIFICADO CON EL ID
				// DEL FORMULARIO SIEMPRE Y CUANDO EL COMPONENTE ESTE DENTRO DEL
				// FORMULARIO
				Acceso_Contextos.addMensaje_Idioma("error.login.clave", null,
						Acceso_Contextos.ERROR, "formu_login:clave_login");
			}
		} else {
			// ERROR EN EL NOMBRE
			Acceso_Contextos.addMensaje_Idioma("error.login.nombre", null,
					Acceso_Contextos.ERROR, "formu_login:nombre_login");
		}
	}
	
	public String desconexion() {
		Acceso_Contextos.desconexion();
		return "/xhtml/login?faces-redirect=true";
	}
	
	// ACCESORES PARA JSF
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	// ACCESORES PARA SPRING
	public void setGestion_usuario(IGestion_Usuario gestion_usuario) {
		this.gestion_usuario = gestion_usuario;
	}

}
