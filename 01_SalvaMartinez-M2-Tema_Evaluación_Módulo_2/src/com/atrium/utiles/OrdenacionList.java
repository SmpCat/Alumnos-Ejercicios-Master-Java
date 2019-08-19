package com.atrium.utiles;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ejemplo de ordenacion de colecciones con tipos propios mediante la interface
 * comparator.
 */
public class OrdenacionList implements Comparator<Object> {
	// PROPIEDADES DE CLASE
	
	// COLECCION A ORDENAR
	private List<?> lista;
	// OBJETO A ORDENAR
	private  Object objeto;
	// CONTROL DEL SENTIDO:1-Ascendente / resto-Descendente
	private int sentido;
	//MÉTODO DE LA PROPIEDAD DE ORDENACIÓN
	private String nombreMetodo;

	/**
	 * Constructores.
	 */

	public OrdenacionList() {
		
	}

	public List<?> ordenar(List<?> lista, Object objeto, int sentido, String nombreMetodo) {
		this.lista = lista;
		this.objeto = objeto;
		this.sentido = sentido;
		this.nombreMetodo = nombreMetodo;
		
		Collections.sort(lista, this);
		return lista;
	}

	/**
	 * Implementacion de la interface {@link Comparator} con la logica de proceso
	 * que hemos querido incluir.
	 * 
	 * @return Valor numero entero que le indicara al metodo sort como quedaran los
	 *         elementos en la tabla.
	 */
	@Override
	public int compare(Object objeto1, Object objeto2) {
		int posicion = 0;
		Method metodo;

		try {
			metodo = this.objeto.getClass().getMethod(this.nombreMetodo);
			if (sentido == 1) {
				posicion = metodo.invoke(objeto1, null).toString().compareTo(metodo.invoke(objeto2, null).toString());
			} else {
				posicion = metodo.invoke(objeto2, null).toString().compareTo(metodo.invoke(objeto1, null).toString());
			}

		} catch (Exception e) {
			((Throwable) e).printStackTrace();
		}
		return posicion;
	}
}
