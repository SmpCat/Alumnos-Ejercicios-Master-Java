package com.atrium.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase para Linea de Pedido
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Entity
@Table(name = "LINEA_PEDIDO_SSG")
public class Linea_Pedido implements java.io.Serializable {

	/*** Serial Version */
	private static final long serialVersionUID = 1L;

	private Integer codigoLineaPedido;
	private Articulos articulos;
	private Pedidos pedidos; 
	private Double precioUnidadArticulo; 
	private Integer numeroUnidadesArticulo; 
	private Double porcentajeDescuento; 

	/** Constructor por defecto */
	public Linea_Pedido() {
	}

	/** Constructor con PK */
	public Linea_Pedido(Integer codigoLineaPedido) {
		super();
		this.codigoLineaPedido = codigoLineaPedido;
	}

	
	/** Constructor con todos los parámetros */
	public Linea_Pedido(Integer codigoLineaPedido, Articulos articulos, Pedidos pedidos,
			Double precioUnidadArticulo, Integer numeroUnidadesArticulo, Double porcentajeDescuento) {
		super();
		this.codigoLineaPedido = codigoLineaPedido;
		this.articulos = articulos;
		this.pedidos = pedidos;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
		this.porcentajeDescuento = porcentajeDescuento;
	}


	// Getters y Setters
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linea_pedido_generator")
	@SequenceGenerator(name="linea_pedido_generator", sequenceName = "CODIGO_LINEA_PEDIDO_SSG",  allocationSize = 1)
	@Column(name = "CODIGO_LINEA_PEDIDO", unique = true, nullable = false)
	public Integer getCodigoLineaPedido() {
		return codigoLineaPedido;
	}

	public void setCodigoLineaPedido(Integer codigoLineaPedido) {
		this.codigoLineaPedido = codigoLineaPedido;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_ARTICULO")
	public Articulos getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Articulos articulos) {
		this.articulos = articulos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUMERO_PEDIDO", nullable=false)
	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	@Column(name = "PRECIO_UNIDAD_ARTICULO", length = 11, precision = 2)
	public Double getPrecioUnidadArticulo() {
		return precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}
	
	@Column(name = "NUMERO_UNIDADES_ARTICULO", length = 5)
	public Integer getNumeroUnidadesArticulo() {
		return numeroUnidadesArticulo;
	}

	public void setNumeroUnidadesArticulo(Integer numeroUnidadesArticulo) {
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
	}

	
	@Column(name = "PORCENTAJE_DESCUENTO", length = 4, precision = 2)
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}