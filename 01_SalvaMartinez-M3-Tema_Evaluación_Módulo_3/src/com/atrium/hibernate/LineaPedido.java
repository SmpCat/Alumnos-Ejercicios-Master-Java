package com.atrium.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LineaPedido entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LINEA_PEDIDO", schema = "J316")
public class LineaPedido implements java.io.Serializable {

	// Fields

	private Long codigoLineaPedido;
	private Pedidos pedidos;
	private Articulos articulos;
	private Double precioUnidadArticulo;
	private Integer numeroUnidadesArticulo;
	private Double porcentajeDescuento;

	// Constructors

	/** default constructor */
	public LineaPedido() {
	}

	/** minimal constructor */
	public LineaPedido(Long codigoLineaPedido) {
		this.codigoLineaPedido = codigoLineaPedido;
	}

	/** full constructor */
	public LineaPedido(Long codigoLineaPedido, Pedidos pedidos,
			Articulos articulos, Double precioUnidadArticulo,
			Integer numeroUnidadesArticulo, Double porcentajeDescuento) {
		this.codigoLineaPedido = codigoLineaPedido;
		this.pedidos = pedidos;
		this.articulos = articulos;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	// Property accessors
	@Id
	@Column(name = "CODIGO_LINEA_PEDIDO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getCodigoLineaPedido() {
		return this.codigoLineaPedido;
	}

	public void setCodigoLineaPedido(Long codigoLineaPedido) {
		this.codigoLineaPedido = codigoLineaPedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUMERO_PEDIDO")
	public Pedidos getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_ARTICULO")
	public Articulos getArticulos() {
		return this.articulos;
	}

	public void setArticulos(Articulos articulos) {
		this.articulos = articulos;
	}

	@Column(name = "PRECIO_UNIDAD_ARTICULO", precision = 11)
	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}

	@Column(name = "NUMERO_UNIDADES_ARTICULO", precision = 5, scale = 0)
	public Integer getNumeroUnidadesArticulo() {
		return this.numeroUnidadesArticulo;
	}

	public void setNumeroUnidadesArticulo(Integer numeroUnidadesArticulo) {
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
	}

	@Column(name = "PORCENTAJE_DESCUENTO", precision = 4)
	public Double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}