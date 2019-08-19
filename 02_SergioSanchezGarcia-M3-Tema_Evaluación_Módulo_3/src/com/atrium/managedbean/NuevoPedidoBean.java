package com.atrium.managedbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.atrium.controlador.CalculoDePedidos;
import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.modelo.IGestion_Articulos;
import com.atrium.hibernate.modelo.IGestion_Pedidos;
import com.atrium.util.Acceso_Contextos;

/**
 * Soporte de datos para la creación de Pedidos
 * 
 * @author Sergio Sánchez García
 * @version 1.7
 * @version 03-07-2019.
 * 
 */
@ManagedBean(name = "nuevoPedido")
@ViewScoped

public class NuevoPedidoBean implements Serializable {
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	ResourceBundle rb = ResourceBundle.getBundle("com.atrium.properties.props");
	// Contenido Nuevo Pedido
	private List<Articulos> lista_articulos;


	@ManagedProperty("#{gestion_articulos}")
	private IGestion_Articulos gestion_articulos;
	
	@ManagedProperty("#{gestion_pedidos}")
	private IGestion_Pedidos gestion_pedidos;
	// PEDIDO SELECCIONADO
	private CalculoDePedidos calculador = new CalculoDePedidos(); 
	private Map<Integer, String> unidades = new HashMap<Integer, String>();	
	private Map<Articulos, Integer> mapaArticulos = new HashMap<Articulos, Integer>();
	private Map<Integer, Boolean> seleccionado = new HashMap<Integer, Boolean>();
	
	/** Constructor **/

	public NuevoPedidoBean() {
		super();
	}

	@PostConstruct
	public void cargar_Pedidos() {
		lista_articulos = gestion_articulos.consultar_Todos();
		setLista_articulos(lista_articulos);
	}


	


	// Setters and getters for above...

	public String generarPedido() 
	{
	    Integer codArticulo;

	    for (Articulos articulo: lista_articulos) 
	    {
	    	codArticulo = articulo.getCodigoArticulo(); 
	        if(seleccionado.get(codArticulo) != null && unidades.get(codArticulo) != "")
	        {
	           // Verificamos que el checkbox esté seleccionado
	           if (seleccionado.get(codArticulo)) 
	            {
	        	   
	   	    	Integer unidad = Integer.valueOf(unidades.get(codArticulo)); 

	                // Add product to list of products to be compared.
	        	   mapaArticulos.put(articulo, unidad);
	            } 
	        }

	    } 
	    if(mapaArticulos.isEmpty())
	    {
	        // Error message that is displayed in the 'ErrorPage.xhtml' file.
	    	Acceso_Contextos.addMensaje_Idioma("error.pedido.vacio", null,Acceso_Contextos.ERROR, "formu_login:tbl");
	        return "";
	    } else {
	    	HashSet<Linea_Pedido> lineasPedidoAInsertar= calculador.generarLineasPedidos(mapaArticulos);
	    	Pedidos pedidoAInsertar = calculador.generarPedido(lineasPedidoAInsertar); 
			gestion_pedidos.alta_Pedido(pedidoAInsertar);
			return rb.getString("pagina.pedidoGenerado");
	    }

	}



	public String volverAMenu() {
		
		return rb.getString("pagina.menu");
	
	}
	
	
	// Accesores de JSF   
	    
	public List<Articulos> getLista_articulos() {
		return lista_articulos;
	}

	public void setLista_articulos(List<Articulos> lista_articulos) {
		this.lista_articulos = lista_articulos;
	}

	public IGestion_Articulos getGestion_articulos() {
		return gestion_articulos;
	}

	public void setGestion_articulos(IGestion_Articulos gestion_articulos) {
		this.gestion_articulos = gestion_articulos;
	}
	
	public Map<Integer, Boolean> getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Map<Integer, Boolean> seleccionado) {
		this.seleccionado = seleccionado;
	}
	public IGestion_Pedidos getGestion_pedidos() {
		return gestion_pedidos;
	}

	public void setGestion_pedidos(IGestion_Pedidos gestion_pedidos) {
		this.gestion_pedidos = gestion_pedidos;
	}
	
	public  Map<Articulos, Integer> getMapaArticulos() {
		return mapaArticulos;
	}

	public void setMapaArticulos( Map<Articulos, Integer> mapaArticulos) {
		this.mapaArticulos = mapaArticulos;
	}
	
	public  Map<Integer, String> getUnidades() {
		return unidades;
	}

	public void setUnidades( Map<Integer, String> unidades) {
		this.unidades = unidades;
	}

}
