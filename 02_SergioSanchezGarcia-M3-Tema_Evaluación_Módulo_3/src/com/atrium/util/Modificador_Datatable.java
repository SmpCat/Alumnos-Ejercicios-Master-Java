package com.atrium.util;

import java.io.Serializable;

import javax.faces.component.UIComponent;

import org.icefaces.ace.component.datatable.DataTable;
import org.icefaces.ace.model.table.RowState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;

/**
 * Modificacion del comportamiento del expansiontoggler.
 * 
 * 
 */
@Component("modificador")
@Scope("prototype")
public class Modificador_Datatable implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Proceso de cierre de todos los expasiontoggler abiertos distintos del
	 * seleccionado.
	 * 
	 * @param componente
	 *            El UICompent del datatable que lanza el evento
	 */
	public void cerrar_PanelExpasion(UIComponent componente) {
		// PREPARAMOS LOS OBJETOS NECESARIOS DEL CONTEXTO DE JSF PARA REALIZAR
		// EL TRABAJO BUSCAMOS LA TABLA (OBJETO DATATABLE) A PARTIR DEL
		// COMPONENTE QUE GENERA EL EVENTO
		DataTable tabla_buscada = null;
		UIComponent nodo_anterior = componente;
		// VAMOS RECORRIENDO A LA INVERSA EL ARBOL DE NODOS PARA LLEGAR A LA
		// TABLA
		while (nodo_anterior != null) {
			if (nodo_anterior instanceof DataTable) {
				tabla_buscada = ((DataTable) nodo_anterior);
				break;
			} else {
				nodo_anterior = nodo_anterior.getParent();
			}
		}
		// UNA VEZ TENEMOS LA TABLA RECOGEMOS LA FILA SELECCIONADA
		Integer fila_seleccionada = tabla_buscada.getRowIndex();
		int numero_filas = tabla_buscada.getRowCount();
		// RECORREMOS TODAS LAS FILAS CERRANDO EL EXPANSIONTOGGLE MENOS EN LA
		// SELECCIONADA
		for (int fila = 0; fila < numero_filas; fila++) {
			if (fila == fila_seleccionada) {
				// COLOCAMOS COMO FILA ACTIVA LA TRATADA POR EL FOR
				tabla_buscada.setRowIndex(fila);
				// LANZAMOS PROGRAMATICAMENTA LA EXPRESION QUE RECUPERA EL
				// ROWSTATE
				RowState interruptor = Ejecucion_Expresiones.tratar_Expresion(
						"#{rowState}", RowState.class);
				// ARREGLAR CASO RARO DE SELECCION AL CERRAR LO ABRIMOS
				// EN LA VERSION 4.X NO SE ABRE SE DEJA AL EXPANSIONTOGGLER
				// interruptor.setExpanded(true);
			} else {
				// COLOCAMOS COMO FILA ACTIVA LA TRATADA POR EL FOR
				tabla_buscada.setRowIndex(fila);
				// LANZAMOS PROGRAMATICAMENTA LA EXPRESION QUE RECUPERA EL
				// ROWSTATE
				RowState interruptor = Ejecucion_Expresiones.tratar_Expresion(
						"#{rowState}", RowState.class);
				// LO CERRAMOS
				interruptor.setExpanded(false);
			}
		}
	}
	
	
	
	/**
	 * Método que obtiene el objeto fila a partir de los elementos del xhtml
	 * @author Sergio Sánchez García
	 * @param componente
	 * @return
	 */
	public Pedidos obtenerFila(UIComponent componente) {
		// Objeto DataTable
		DataTable tabla_buscada = null;
		UIComponent nodo_anterior = componente;
		// Recorremos los nodos
		while (nodo_anterior != null) {
			if (nodo_anterior instanceof DataTable) {
				tabla_buscada = ((DataTable) nodo_anterior);
				break;
			} else {
				nodo_anterior = nodo_anterior.getParent();
			}
		}
		// Buscamos la fila seleccionada
		Integer fila_seleccionada = tabla_buscada.getRowIndex();
		int numero_filas = tabla_buscada.getRowCount();
		// Devolvemos el valor del Objeto Pedido al encontrarlo
		for (int fila = 0; fila < numero_filas; fila++) {
			if (fila == fila_seleccionada) {
								return (Pedidos) tabla_buscada.getRowData(); 
				
			}
		}
		return null;
	}
	
	
	/**
	 * Método que obtiene el objeto fila a partir de los elementos del xhtml
	 * @author Sergio Sánchez García
	 * @param componente
	 * @return
	 */
	public Linea_Pedido obtenerArticulo(UIComponent componente) {
		// Objeto DataTable
		DataTable tabla_buscada = null;
		UIComponent nodo_anterior = componente;
		// Recorremos los nodos
		while (nodo_anterior != null) {
			if (nodo_anterior instanceof DataTable) {
				tabla_buscada = ((DataTable) nodo_anterior);
				break;
			} else {
				nodo_anterior = nodo_anterior.getParent();
			}
		}
		// Buscamos la fila seleccionada
		Integer fila_seleccionada = tabla_buscada.getRowIndex();
		int numero_filas = tabla_buscada.getRowCount();
		// Devolvemos el valor del Objeto Pedido al encontrarlo
		for (int fila = 0; fila < numero_filas; fila++) {
			if (fila == fila_seleccionada) {
								return (Linea_Pedido) tabla_buscada.getRowData(); 
				
			}
		}
		return null;
	}
	
	
	
}
