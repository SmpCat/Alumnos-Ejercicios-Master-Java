package com.atrium.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atrium.filtros.Filtro_Idioma;

/**
 * Utilidad para el acceso a los distintos contextos
 * 
 * @author Sergio Sánchez García
 * @version 2.0
 * @since 19-07-2019.
 */
public class Acceso_Contextos implements INiveles_FacesContext {

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.
	 * 
	 * @param mensaje_sumario
	 *            Texto para el sumario del mensaje, no es obligatorio.
	 * @param mensaje_detalle
	 *            Texto para el detalle del mensaje, no es obligatorio.
	 * @param identificador
	 *            Identificador del mensaje, para luego ser llamado en la vista.
	 * @param nivel
	 *            Nivel de resalte del mensaje, no es obligatorio.
	 */
	public static void addMensaje(String mensaje_sumario,
			String mensaje_detalle, Severity nivel, String identificador) {
		if (nivel == null) {
			nivel = INFO;
		}
		// Generación del mensaje
		FacesContext.getCurrentInstance().addMessage(identificador,
				new FacesMessage(nivel, mensaje_sumario, mensaje_detalle));
	}

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.<br/>
	 * En esta metodo no se envian los textos, solo las claves para los
	 * properties. Por lo tanto es necesario crear el ResourceBundle que lea del
	 * properties correspondiente.
	 * 
	 * @param mensaje_sumario
	 *            Clave para el properties que sera el sumario del mensaje, no
	 *            es obligatorio.
	 * @param mensaje_detalle
	 *            Clave para el properties que sera el para el detalle del
	 *            mensaje, no es obligatorio.
	 * @param identificador
	 *            Identificador del mensaje, para luego ser llamado en la vista.
	 * @param nivel
	 *            Nivel de resalte del mensaje, no es obligatorio.
	 */
	public static void addMensaje_Idioma(String clave_sumario,
			String clave_detalle, Severity nivel, String identificador) {
			
		ResourceBundle rb;
		try {
			rb = ResourceBundle.getBundle((String) getSesion().getAttribute("idioma_seleccionado"));

			String sumario = "";
			String detalle = "";
			// Idioma preferido por el usuario
			if (clave_detalle != null && !clave_detalle.equals("")) {
				detalle = rb.getString(clave_detalle);
			}
			if (clave_sumario != null && !clave_sumario.equals("")) {
				sumario = rb.getString(clave_sumario);
			}
			// Nivel por defecto
			if (nivel == null) {
				nivel = INFO;
			}
			FacesContext.getCurrentInstance().addMessage(identificador,
					new FacesMessage(nivel, sumario, detalle));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo de conveniencia para la inclusion de mensajes en los managedbean
	 * sin tener que llamar todo el rato al facescontext.<br/>
	 * En esta metodo no se envian los textos, solo las claves para los
	 * properties. Por lo tanto es necesario crear el ResourceBundle que lea del
	 * properties correspondiente.
	 * 
	 * @param clave_sumario
	 *            Clave para el properties que sera el sumario del mensaje, no
	 *            es obligatorio.
	 * 
	 * @param valores_sumario
	 *            Tabla de String para la personalizacion del mensaje. La logica
	 *            es posicional, cada variable esta numerada y coincidira con la
	 *            posicion en la tabla.
	 * @param clave_detalle
	 *            Clave para el properties que sera el para el detalle del
	 *            mensaje, no es obligatorio.
	 * @param valores_detalle
	 *            Tabla de String para la personalizacion del mensaje. La logica
	 *            es posicional, cada variable esta numerada y coincidira con la
	 *            posicion en la tabla.
	 * @param identificador
	 *            Identificador del mensaje, para luego ser llamado en la vista.
	 * @param nivel
	 *            Nivel de resalte del mensaje, no es obligatorio.
	 */
	public static void addMensaje_Idioma(String clave_sumario,
			String valores_sumario[], String clave_detalle,
			String valores_detalle[], Severity nivel, String identificador) {
		try {
			ResourceBundle rb = ResourceBundle.getBundle((String) getSesion()
					.getAttribute("idioma_seleccionado"));

			String sumario = "";
			String detalle = "";
			// Idioma preferido
			if (clave_detalle != null && !clave_detalle.equals("")) {
				detalle = rb.getString(clave_detalle);
			}
			if (clave_sumario != null && !clave_sumario.equals("")) {
				sumario = rb.getString(clave_sumario);
			}

			if (valores_sumario != null && valores_sumario.length > 0) {
				sumario = MessageFormat.format(sumario, valores_sumario);
			}
			if (valores_detalle != null && valores_detalle.length > 0) {
				detalle = MessageFormat.format(detalle, valores_detalle);
			}
			// Nivel por defecto
			if (nivel == null) {
				nivel = INFO;
			}
			// Generar Mensaje
			FacesContext.getCurrentInstance().addMessage(identificador,
					new FacesMessage(nivel, sumario, detalle));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Proceso de conveniencia para recoger el valor de un atributo de sesion.
	 * 
	 * @param nombre_atributo
	 * @return
	 */
	public static Object getAtributo(String nombre_atributo) {
		return getSesion().getAttribute(nombre_atributo);
	}

	/**
	 * Proceso de conveniencia para dar valor a un atributo de sesion.
	 * 
	 * @param nombre_atributo
	 * @return
	 */
	public static void setAtributo(String nombre_atributo, Object objeto_valor) {
		getSesion().setAttribute(nombre_atributo, objeto_valor);
	}

	/**
	 * Devuelve la sesion si existe. De no existir no devuelve nada, no crea una
	 * nueva.
	 * 
	 * @return Sesion en curso. {@link HttpSession}
	 */
	public static HttpSession getSesion() {
		HttpSession salida = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return salida;
	}
	
	
	/**
	 * Invalida la sesion
	 */
	public static void desconexion() {

		HttpSession session = getSesion();
		session.invalidate();
	}

	/**
	 * Devuelve la peticion de en curso.
	 * 
	 * @return Peticion en curso. {@link HttpServletRequest}
	 */
	public static HttpServletRequest getPeticion() {
		HttpServletRequest peticion = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return peticion;
	}

	/**
	 * Devuelve el contexto de aplicacion correspondiente.
	 * 
	 * @return Contexto de aplicion JEE. {@link ServletContext}
	 */
	public static ServletContext getAplicacion() {
		ServletContext aplicacion = ((HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(false))
				.getServletContext();
		return aplicacion;
	}

	/**
	 * Método que realiza una recarga de la página
	 * @author Sergio Sánchez García 
	 */
	public static void recargarPagina() {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve la respuesta de en curso.
	 * 
	 * @return Respuesta en curso. {@link HttpServletResponse}
	 */
	public static HttpServletResponse getRespuesta() {
		HttpServletResponse respuesta = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		return respuesta;
	}

	/**
	 * Devuelve el applicationContext de spring para su uso.
	 * 
	 * @return ApplicationContext de spring. {@link ApplicationContext}
	 */
	public static ApplicationContext getApplication_Context() {
		ApplicationContext application = WebApplicationContextUtils
				.getWebApplicationContext(Acceso_Contextos.getAplicacion());
		return application;
	}

}
