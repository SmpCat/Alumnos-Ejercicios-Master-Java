package com.atrium.filtros;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atrium.controlador.Constantes;

/**
 * Filtro de Sesión
 * @author Sergio Sánchez García
 * @version 2.0
 */

@WebFilter(filterName = "Filtro_Sesion", urlPatterns = { "*.xhtml" })
public class Filtro_Sesion implements Filter {
	
	private ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	

	public Filtro_Sesion() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			// Excepciones al Filtro de Sesión
			if (reqURI.indexOf(rb.getString("pagina.login.ini")) >= 0
					|| reqURI.indexOf(rb.getString("pagina.registro.ini")) >= 0
					|| reqURI.indexOf(rb.getString("pagina.registrado.ini")) >= 0
					|| (ses != null && ses.getAttribute(Constantes.USUARIO) != null)
					|| reqURI.contains(Constantes.RESOURCE))
				chain.doFilter(request, response);
			else
				resp.sendRedirect(reqt.getContextPath() + rb.getString("pagina.login.ini"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}