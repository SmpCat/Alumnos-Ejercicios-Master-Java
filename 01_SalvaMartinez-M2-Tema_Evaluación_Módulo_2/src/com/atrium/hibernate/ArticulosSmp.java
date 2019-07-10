package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * ArticulosSmp entity. @author MyEclipse Persistence Tools
 */

public class ArticulosSmp implements java.io.Serializable {

	// Fields

	private Integer codigoArticulo;
	private String descripcionArticulo;
	private Double precioUnidadArticulo;
	private Integer cantidad;
	private Set lineaPedidoSmps = new HashSet(0);

	// Constructors

	/** default constructor */
	public ArticulosSmp() {
	}

	/** full constructor */
	public ArticulosSmp(String descripcionArticulo, Double precioUnidadArticulo, Integer cantidad,
			Set lineaPedidoSmps) {
		this.descripcionArticulo = descripcionArticulo;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.cantidad = cantidad;
		this.lineaPedidoSmps = lineaPedidoSmps;
	}

	// Property accessors

	public Integer getCodigoArticulo() {
		return this.codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Set getLineaPedidoSmps() {
		return this.lineaPedidoSmps;
	}

	public void setLineaPedidoSmps(Set lineaPedidoSmps) {
		this.lineaPedidoSmps = lineaPedidoSmps;
	}

}