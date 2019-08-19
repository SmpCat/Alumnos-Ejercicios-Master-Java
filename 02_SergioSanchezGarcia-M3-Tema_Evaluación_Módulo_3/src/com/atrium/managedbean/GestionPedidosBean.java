package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.ExpansionChangeEvent;

import com.atrium.controlador.CalculoDePedidos;
import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Linea_Pedido;
import com.atrium.hibernate.modelo.IGestion_Pedidos;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.util.Acceso_Contextos;
import com.atrium.util.Ejecucion_Expresiones;
import com.atrium.util.Modificador_Datatable;

/**
 * Soporte de datos para la gestión de Pedidos
 * 
 * @author Sergio Sánchez García
 * @version 1.7
 * @version 03-07-2019.
 * 
 */
@ManagedBean(name = "pedidos_bean")
@ViewScoped

public class GestionPedidosBean implements Serializable {
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	// CONTENIDO DEL DATATABLE
	private List<Pedidos> lista_pedidos;
	private List<Linea_Pedido> lista_lineaPedidos; 
	@ManagedProperty("#{gestion_pedidos}")
	private IGestion_Pedidos gestion_pedidos;
	@ManagedProperty("#{gestion_linea_pedido}")
	private IGestion_Linea_Pedido gestion_linea_pedido;
	@ManagedProperty("#{gestion_usuario}")
	private IGestion_Usuario gestion_usuario;
	@ManagedProperty("#{modificador}")
	private Modificador_Datatable modificador_datatable;
	// PEDIDO SELECCIONADO
	private Pedidos pedido_seleccionado;
	private Linea_Pedido lineaPedido_seleccionado; 
	private String nombreUsuario; 

	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");

	public GestionPedidosBean() {
		super();
		nombreUsuario = getnomUsu(); 
	}

	@PostConstruct
	public void cargar_Pedidos() {
		lista_pedidos = gestion_pedidos.consultar_todos(nombreUsuario);
		setLista_pedidos(lista_pedidos);
	}

	/**
	 * Obtención del nombre de usuario guardado
	 * en la sesión.
	 */

	public String getnomUsu() {
		 Usuarios usuario = (Usuarios)Acceso_Contextos.getAtributo("usuario");
		 return usuario.getCodUsuario(); 
	}
	
	public String volverAMenu() {
		return rb.getString("pagina.menu");
	}
	
	
	public void evento_SeleccionDetalle(ExpansionChangeEvent evento) {
		
		gestion_usuario = Ejecucion_Expresiones.tratar_Expresion(
				"#{gestion_usuario}", IGestion_Usuario.class);
		
		// Obtencion de pedido seleccionado
		pedido_seleccionado = (Pedidos) evento.getRowData();
		
		
		// Obtener lista de lineas de pedido 
		lista_lineaPedidos = new ArrayList<Linea_Pedido>(pedido_seleccionado.getLineaPedido()); 
		
		
		// MODIFICACION DE COMPORTAMIENTO DE DATATABLE
		 modificador_datatable.cerrar_PanelExpasion(evento.getComponent());
	}

	/**
	 * Evento que genera los datos necesarios para después poder 
	 * eliminar el Pedido seleccionado
	 * @param e
	 */
	public void eventoEliminar(ActionEvent e) {
		
		// Obtencion de pedido seleccionado
		
		pedido_seleccionado = modificador_datatable.obtenerFila(e.getComponent());
		
		gestion_pedidos = Ejecucion_Expresiones.tratar_Expresion(
				"#{gestion_pedidos}", IGestion_Pedidos.class);
		
	}
	
	/**
	 * Evento que genera los datos necesarios para después poder 
	 * eliminar el Artículo seleccionado
	 * @param e
	 */
	public void eventoEliminarArticulo(ActionEvent e) {
		
		// Obtencion de Artículo seleccionado
		
		lineaPedido_seleccionado = modificador_datatable.obtenerArticulo(e.getComponent());

	}
	
	/**
	 * Método sin acción
	 */
	public void noAccion() {
		// No quiero que realice acción ninguna pero sí el ActionListener
	}
	
	/**
	 * Método que elimina un Pedido 
	 */
	public void eliminarPedido(){
		gestion_pedidos.baja_Pedido(pedido_seleccionado);
		Acceso_Contextos.recargarPagina();
		
	}
	
	/**
	 * Método que elimina una Línea de Pedido 
	 */
	public void eliminarLineaPedido(){
		
		//gestion_linea_pedido.baja_Linea_Pedido(lineaPedido_seleccionado);
		CalculoDePedidos calculoPedidos = new CalculoDePedidos();
		pedido_seleccionado.getLineaPedido().remove(lineaPedido_seleccionado);
		if (pedido_seleccionado.getLineaPedido().isEmpty()) {
			gestion_pedidos.baja_Pedido(pedido_seleccionado);
		}else {
		pedido_seleccionado = calculoPedidos.recalculaPedido(pedido_seleccionado);
		gestion_pedidos.modificacion_Pedido(pedido_seleccionado);
		}
		Acceso_Contextos.recargarPagina();
		
	}

	// Accesores
	public List<Pedidos> getLista_pedidos() {
		return lista_pedidos;
	}

	public void setLista_pedidos(List<Pedidos> lista_pedidos) {
		this.lista_pedidos = lista_pedidos;
	}
	
	public List<Linea_Pedido> getLista_lineaPedidos() {
		return lista_lineaPedidos;
	}

	public void setLista_lineaPedidos(List<Linea_Pedido> lista_lineaPedidos) {
		this.lista_lineaPedidos = lista_lineaPedidos;
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

	public IGestion_Linea_Pedido getGestion_linea_pedido() {
		return gestion_linea_pedido;
	}

	public void setGestion_linea_pedido(IGestion_Linea_Pedido gestion_linea_pedido) {
		this.gestion_linea_pedido = gestion_linea_pedido;
	}

	public IGestion_Usuario getGestion_usuario() {
		return gestion_usuario;
	}

	public void setGestion_usuario(IGestion_Usuario gestion_usuario) {
		this.gestion_usuario = gestion_usuario;
	}

	public Linea_Pedido getLineaPedido_seleccionado() {
		return lineaPedido_seleccionado;
	}

	public void setLineaPedido_seleccionado(Linea_Pedido lineaPedido_seleccionado) {
		this.lineaPedido_seleccionado = lineaPedido_seleccionado;
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
