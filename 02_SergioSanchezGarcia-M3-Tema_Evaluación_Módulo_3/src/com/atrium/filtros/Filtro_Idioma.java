package com.atrium.filtros;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atrium.controlador.Constantes;
import com.atrium.hibernate.Usuarios;

/**
 * Filtro de Sesión. Adquiere el idioma del navegador hasta que el 
 * usuario se logea, momento en el cuál predomina el idioma del perfil
 * del Usuario
 * 
 * @author Sergio Sánchez García
 * @version 2.0
 */

public class Filtro_Idioma implements Filter {

	// Variables
	private boolean no_elegido = true;
	private String idioma_defecto;
	private Logger log = LoggerFactory.getLogger(Filtro_Idioma.class);
	private ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");

	/**
	 * Establecemos el idioma por defecto. Leido de web.xml.
	 * 
	 * @param filterConfig
	 *            Objeto que nos permitira acceder a los contexto y su
	 *            informacion para cualquier necesidad de proceso.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		idioma_defecto = rb.getString("ruta.idioma.defecto")
				+ filterConfig.getServletContext().getInitParameter(
						Constantes.IDIOMA_DEFECTO);
	}

	/**
	 * Se carga el idioma por defecto salvo que haya una sesión y exista 
	 * el atributo de usuario
	 */
	public void doFilter(ServletRequest peticion, ServletResponse respuesta,
			FilterChain cadena_peticion) throws IOException, ServletException {
		// Idioma por defecto
		String idioma_elegido_peticion = idioma_defecto;

		HttpServletRequest mi_request = null;
		if (peticion instanceof HttpServletRequest) {
			mi_request = (HttpServletRequest) peticion;
		}
	        HttpSession session = mi_request.getSession();
	        String idioma_preferido;
	        // Si se encuentra logado coge el idioma del perfil
		if (session != null && (session.getAttribute(Constantes.USUARIO) != null)) {
			Usuarios usuario = (Usuarios) session.getAttribute(Constantes.USUARIO);
			idioma_preferido = usuario.getIdioma(); 

		}else {
		// Sino está logado coge el por defecto del navegador
		 idioma_preferido = mi_request.getHeader("accept-language");
		}
		String lista_idiomas[] = idioma_preferido.split(",");
		// Se busca entre varios del navegador
		for (int i = 0; i < lista_idiomas.length; i++) {
			if (lista_idiomas[i].substring(0, 2).equals(rb.getString("idioma.es")) && no_elegido) {
				idioma_elegido_peticion = rb.getString("ruta.idioma.es");
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals(rb.getString("idioma.en")) && no_elegido) {
				idioma_elegido_peticion = rb.getString("ruta.idioma.en");
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals(rb.getString("idioma.fr")) && no_elegido) {
				idioma_elegido_peticion = rb.getString("ruta.idioma.fr");
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals(rb.getString("idioma.ge")) && no_elegido) {
				idioma_elegido_peticion = rb.getString("ruta.idioma.ge");
				no_elegido = false;
			}
		}
		
	
		// Se guarda en la sesión
		mi_request.getSession().setAttribute("idioma_seleccionado",	idioma_elegido_peticion);
		no_elegido = true;
		if (log.isTraceEnabled()) {
			log.trace("Idioma inicial escogido: " + idioma_elegido_peticion);
		}
		cadena_peticion.doFilter(peticion, respuesta);
	}

	/**
	 * Solo informamos de la finalizacion del filtro para el seguimiento de la
	 * aplicacion.
	 */
	@Override
	public void destroy() {
		if (log.isTraceEnabled()) {
			log.trace("Se destruye el Filtro de idioma");
		}
	}

}
