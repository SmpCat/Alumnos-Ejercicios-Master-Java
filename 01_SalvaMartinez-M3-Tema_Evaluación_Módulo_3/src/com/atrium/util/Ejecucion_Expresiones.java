package com.atrium.util;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import org.icefaces.ace.model.table.RowState;

/**
 * Proceso auxiliar para la ejecucion de experesiones UEL dentro de un proyecto
 * JSF.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 23-5-2016.
 * 
 */
public class Ejecucion_Expresiones {

	/**
	 * Metodo de auxiliar que nos permite ejecutar expresiones en clases de
	 * java.
	 * 
	 * @param expresion
	 *            Texto con la expresion a ejecutar.
	 * @param valor_devuelto
	 *            Tipo del valor de retorno.
	 * @return Objeto resultado de la expresion, casteado al tipo requerido.
	 */
	public static <T> T tratar_Expresion(String expresion,
			Class<T> valor_devuelto) {
		// PREPARAMOS LOS OBJETOS NECESARIOS DEL CONTEXTO DE JSF PARA REALIZAR
		// EL TRABAJO
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// OBJETO DE JSF QUE EJECUTA LA EXPRESION
		ELContext elContext = facesContext.getELContext();
		// OBJETO DE JSF PARA EL ACCESO A LOS COMPONENTES INTERNOS (NO VISTAS)
		Application application = facesContext.getApplication();
		// OBJETO PARA LA CREACION DE LANZADORES DE EXPRESIONES
		ExpressionFactory expressionFactory = application
				.getExpressionFactory();
		// PREPARAMOS UN LANZADOR DE EXPRESIONES PARA LA VISTA EN LA QUE ESTAMOS
		// Y ASI PODER ACCEDER AL MODELO DE LA TABLA
		ValueExpression lanzador_expresiones = expressionFactory
				.createValueExpression(elContext, expresion, valor_devuelto);
		// SE EJECUTA LA EXPRESSION
		Object valor_expresion = lanzador_expresiones.getValue(elContext);
		// DEVOLVEMOS EL VALOR EN TIPO REQUERIDO
		return (T) valor_expresion;
	}

}
