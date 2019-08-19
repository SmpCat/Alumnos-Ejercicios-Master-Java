package com.atrium.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.util.Acceso_Contextos;
import com.atrium.util.Ejecucion_Expresiones;

@ManagedBean(name = "registroBean")
@ViewScoped
public class RegistroUsuarioBean implements Serializable {
	/**
	 * SerialVersion 
	 */
	private static final long serialVersionUID = 1L;
	// PROPIEDADES PARA RECIBIR LOS VALORES DE LOS COMPONENTES
	private String nombreUsuario;
	private String claveUsuario;
	private String repetirClaveUsuario; 
	private String seleccionIdiomaUsuario; 
	private String dni; 
	private String email; 
	private boolean correcto;
	
	@ManagedProperty("#{gestion_usuario}")
	private IGestion_Usuario gestion_usuario;

	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	
	
	
	public RegistroUsuarioBean() {
		correcto = Boolean.FALSE; 
	}

	
	/**
	 * Metodo para volver a la pantalla de login
	 * 
	 * @return
	 */
	public String volverLogin() {
		return rb.getString("pagina.login");
	}
	
	/**
	 * Metodo de comprobación de Datos
	 * 
	 * @return
	 */
	public String comprobarDatos() {
		
		if (correcto) {
			// Creamos el usuario
			crearUsuario();  	
			return rb.getString("pagina.registrado");
		}
		return "";
	}

	/**
	 * Metodo de evento de comprobación de datos.
	 */
	public void eventoComprobarDatos(ActionEvent evento) {
		// VERIFICAMOS PARAMETROS
		if (verificarNombre() && verificarClave() && verificarDNI() && verificarEmail()) {
			correcto = Boolean.TRUE; 
		}	
	}

	/**
	 * VERIFICAMOS EL NOMBRE DE USUARIO
	 * @return Boolean (verificación del campo)
	 */
	
	private Boolean verificarNombre() {
	
		// Si es nulo informamos que está vacío
		if (nombreUsuario == null || nombreUsuario.trim().equals("")) {
			Acceso_Contextos.addMensaje_Idioma("error.registro.nombreVacio", null,Acceso_Contextos.ERROR, "formRegistro:nombreUsuario");
			return Boolean.FALSE; 
		}
		
		if (nombreUsuario.length()> 4) {
			 for (int i = 0; i < nombreUsuario.length(); i++){
                char c = nombreUsuario.charAt(i);

                if (       ('a' <= c && c <= 'z') // Verifica minusculas
                        || ('A' <= c && c <= 'Z') // Verifica Mayusculas
                        || ('0' <= c && c <= '9') // Verifica números
                ) 
                {/* Correcto */} 
                else {
                    // No se permiten esos caracteres
               	 Acceso_Contextos.addMensaje_Idioma("error.registro.claveCaracteres", null,Acceso_Contextos.ERROR, "formRegistro:nombreUsuario");
               	 return Boolean.FALSE; 
                }            
			 }
		}else {
		
		Acceso_Contextos.addMensaje_Idioma("error.registro.noombreLongitud", null,Acceso_Contextos.ERROR, "formRegistro:nombreUsuario");	
		return Boolean.FALSE;
		}
		
		
		// Buscamos el usuario en BBDD
		Usuarios usuario = Ejecucion_Expresiones.tratar_Expresion
										("#{gestion_usuario}", IGestion_Usuario.class)
										.consultar_PorNombre(getNombreUsuario());	
		// Si existe informamos 
		if (usuario != null) {
			// Informamos de que el nombre ya existe
			Acceso_Contextos.addMensaje_Idioma("error.registro.nombre", null,Acceso_Contextos.ERROR, "formRegistro:nombreUsuario");
			return Boolean.FALSE; 
		}			
		// Verificamos que es correcto
		Acceso_Contextos.addMensaje_Idioma("info.registro.nombre", null,Acceso_Contextos.INFO, "formRegistro:nombreUsuario");
		return Boolean.TRUE; 
	}
	
	
	/**
	 * VERIFICAMOS LA CONTRASEÑA
	 * @return Boolean (verificación del campo)
	 */
	
	private Boolean verificarClave() {
		
		// Comprobamos que no venga vacía
		if (claveUsuario == null || claveUsuario.trim().equals("")) {
			Acceso_Contextos.addMensaje_Idioma("error.registro.claveVacia", null,Acceso_Contextos.ERROR, "formRegistro:claveUsuario");
			return Boolean.FALSE; 
		}
		
			if (claveUsuario.length()> 4) {
				 for (int i = 0; i < claveUsuario.length(); i++){
	                 char c = claveUsuario.charAt(i);
	
	                 if (       ('a' <= c && c <= 'z') // Verifica minusculas
	                         || ('A' <= c && c <= 'Z') // Verifica Mayusculas
	                         || ('0' <= c && c <= '9') // Verifica números
	                 ) 
	                 {/* Correcto */} 
	                 else {
	                     // No se permiten esos caracteres
	                	 Acceso_Contextos.addMensaje_Idioma("error.registro.claveCaracteres", null,Acceso_Contextos.ERROR, "formRegistro:claveUsuario");
	                	 return Boolean.FALSE; 
	                 }
	                
				 }
				 if (claveUsuario.equals(repetirClaveUsuario)) {
	        		 return Boolean.TRUE; 
	        	 } else {
	            	 Acceso_Contextos.addMensaje_Idioma("error.registro.claveNoIgual", null,Acceso_Contextos.ERROR, "formRegistro:repetirClaveUsuario");
	            	 return Boolean.FALSE; 
	        	 } 
			}
			
			Acceso_Contextos.addMensaje_Idioma("error.registro.claveLongitud", null,Acceso_Contextos.ERROR, "formRegistro:claveUsuario");	
			return Boolean.FALSE; 
		}

	
	
	/**
	 * VERIFICAMOS EL DNI
	 * @return Boolean (verificación del campo)
	 */
	
	private Boolean verificarDNI() {
		if (dni == null || dni.trim().equals("")) {
			Acceso_Contextos.addMensaje_Idioma("error.registro.dniNulo", null,Acceso_Contextos.ERROR, "formRegistro:dni");	
			return Boolean.FALSE; 
		}
		if (dni.length()< 10) {
			Acceso_Contextos.addMensaje_Idioma("error.registro.dniIncompleto", null,Acceso_Contextos.ERROR, "formRegistro:dni");	
			return Boolean.FALSE; 
		}
		return Boolean.TRUE;
		
	}
	
	
	/**
	 * VERIFICAMOS EL EMAIL
	 * @return Boolean (verificación del campo)
	 */
	private Boolean verificarEmail() {
		
		String patron = "^[a-zA-Z0-9_+&*-]+(?:\\."+
		                            "[a-zA-Z0-9_+&*-]+)*@" + 
		                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
		                            "A-Z]{2,7}$"; 
		                              
		Pattern pat = Pattern.compile(patron); 
		if (email == null || email.trim().equals("")) {
			Acceso_Contextos.addMensaje_Idioma("error.registro.emailNulo", null,Acceso_Contextos.ERROR, "formRegistro:correoElectronico");	
			return Boolean.FALSE; 
		}

		if (pat.matcher(email).matches()) {
			return Boolean.TRUE;
		}
		Acceso_Contextos.addMensaje_Idioma("error.registro.emailPatron", null,Acceso_Contextos.ERROR, "formRegistro:correoElectronico");	
		return Boolean.FALSE;
		    	
	}
	
	
	private void crearUsuario() {
		Usuarios usuario = new Usuarios(); 
		usuario.setCodUsuario(nombreUsuario);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setDni(dni);
		usuario.setEmailCliente(email);
		usuario.setFechaAltaUsuario(new Date());
		usuario.setPassword(claveUsuario);
		usuario.setIdioma(seleccionIdiomaUsuario);
		gestion_usuario.alta_Usuario(usuario);
	}
	
	/**
	 * Método que modifica el idioma de usuario
	 * @param event
	 */
	
	public void cambioIdiomaES() { 
		seleccionIdiomaUsuario = rb.getString("idioma.es"); 
		cambioIdioma(); 
		}
	public void cambioIdiomaEN() { 
		seleccionIdiomaUsuario = rb.getString("idioma.en"); 
		cambioIdioma(); 
		}
	public void cambioIdiomaFR() { 
		seleccionIdiomaUsuario = rb.getString("idioma.fr"); 
		cambioIdioma(); 
		}
	public void cambioIdiomaGE() { 
		seleccionIdiomaUsuario = rb.getString("idioma.ge"); 
		cambioIdioma(); 
		}
	
	public void cambioIdioma() { 
		Usuarios usuario = (Usuarios)Acceso_Contextos.getAtributo("usuario");
		usuario.setIdioma(seleccionIdiomaUsuario);
		gestion_usuario.modificacion_Usuario(usuario);	
		Acceso_Contextos.recargarPagina(); 
		}
	
	
	// ACCESORES PARA JSF

	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getRepetirClaveUsuario() {
		return repetirClaveUsuario;
	}

	public void setRepetirClaveUsuario(String repetirClaveUsuario) {
		this.repetirClaveUsuario = repetirClaveUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSeleccionIdiomaUsuario() {
		return seleccionIdiomaUsuario;
	}


	public void setSeleccionIdiomaUsuario(String idiomaUsuario) {
		this.seleccionIdiomaUsuario = idiomaUsuario;
	}
	

	// ACCESORES PARA SPRING
	public void setGestion_usuario(IGestion_Usuario gestion_usuario) {
		this.gestion_usuario = gestion_usuario;
	}

}
