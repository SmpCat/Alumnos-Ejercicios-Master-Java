package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.ace.event.ExpansionChangeEvent;

import com.atrium.hibernate.Clientes;
import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.modelo.IGestion_Clientes;
import com.atrium.hibernate.modelo.IGestion_Pedidos;
import com.atrium.util.Ejecucion_Expresiones;
import com.atrium.util.Modificador_Datatable;

/**
 * Soporte de datos para el ejemplo del datatable.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @version 5-5-2017.
 * 
 */
@ManagedBean(name = "pedidos_bean")
@ViewScoped
public class Datatable_Bean implements Serializable {
	// CONTENIDO DEL DATATABLE
	private List<Pedidos> lista_pedidos;
	@ManagedProperty("#{gestion_pedidos}")
	private IGestion_Pedidos gestion_pedidos;
	// @ManagedProperty("#{gestion_clientes}")
	private IGestion_Clientes gestion_clientes;
	@ManagedProperty("#{modificador}")
	private Modificador_Datatable modificador_datatable;
	// PEDIDO SELECCIONADO
	private Pedidos pedido_seleccionado;


	@PostConstruct
	public void cargar_Pedidos() {
		lista_pedidos = gestion_pedidos.consultar_Pedidos();;
	}

	/**
	 * Proceso de seleccion del cliente del pedido seleccionado por usuario.
	 * 
	 * @param evento
	 */
	public void evento_SeleccionDetalle(ExpansionChangeEvent evento) {
		gestion_clientes = Ejecucion_Expresiones.tratar_Expresion(
				"#{gestion_clientes}", IGestion_Clientes.class);
		// OBTENEMOS EL OBJETO DE LA COLECCION SELECCIONADO POR EL USUARIO
		pedido_seleccionado = (Pedidos) evento.getRowData();
		// CONSULTAMOS EL PEDIDO CON EL CLIENTE A LA BD.
		Clientes cliente_consultado = gestion_clientes
				.consultar_PorCodigo(pedido_seleccionado.getClientes()
						.getCodigoCliente());
		// PASAMOS LA INFORMACION AL PEDIDO
		pedido_seleccionado.setClientes(cliente_consultado);
		// MODIFICACION DE COMPORTAMIENTO DE DATATABLE
		modificador_datatable.cerrar_PanelExpasion(evento.getComponent());
	}

	// ACCESORES PARA JSF
	public List<Pedidos> getLista_pedidos() {
		return lista_pedidos;
	}

	public void setLista_pedidos(List<Pedidos> lista_pedidos) {
		this.lista_pedidos = lista_pedidos;
	}

	public IGestion_Pedidos getGestion_pedidos() {
		return gestion_pedidos;
	}

	public void setGestion_pedidos(IGestion_Pedidos gestion_pedidos) {
		this.gestion_pedidos = gestion_pedidos;
	}
	
	public Pedidos getPedido_seleccionado() {
		return pedido_seleccionado;
	}

	public void setPedido_seleccionado(Pedidos pedido_seleccionado) {
		this.pedido_seleccionado = pedido_seleccionado;
	}

	public Modificador_Datatable getModificador_datatable() {
		return modificador_datatable;
	}

	public void setModificador_datatable(
			Modificador_Datatable modificador_datatable) {
		this.modificador_datatable = modificador_datatable;
	}

}
