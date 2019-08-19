package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Articulos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ARTICULOS", schema = "J316")
public class Articulos implements java.io.Serializable {

	// Fields

	private Integer codigoArticulo;
	private String descripcionArticulo;
	private Double precioUnidadArticulo;
	private Integer cantidad;
	private Set<LineaPedido> lineaPedidos = new HashSet<LineaPedido>(0);

	// Constructors

	/** default constructor */
	public Articulos() {
	}

	/** minimal constructor */
	public Articulos(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/** full constructor */
	public Articulos(Integer codigoArticulo, String descripcionArticulo,
			Double precioUnidadArticulo, Integer cantidad,
			Set<LineaPedido> lineaPedidos) {
		this.codigoArticulo = codigoArticulo;
		this.descripcionArticulo = descripcionArticulo;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.cantidad = cantidad;
		this.lineaPedidos = lineaPedidos;
	}

	// Property accessors
	@Id
	@Column(name = "CODIGO_ARTICULO", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getCodigoArticulo() {
		return this.codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	@Column(name = "DESCRIPCION_ARTICULO", length = 40)
	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	@Column(name = "PRECIO_UNIDAD_ARTICULO", precision = 11)
	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}

	@Column(name = "CANTIDAD", precision = 5, scale = 0)
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articulos")
	public Set<LineaPedido> getLineaPedidos() {
		return this.lineaPedidos;
	}

	public void setLineaPedidos(Set<LineaPedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

}