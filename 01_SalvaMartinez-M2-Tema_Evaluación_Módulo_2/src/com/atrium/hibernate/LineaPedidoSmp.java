package com.atrium.hibernate;

/**
 * LineaPedidoSmp entity. @author MyEclipse Persistence Tools
 */

public class LineaPedidoSmp implements java.io.Serializable {

	// Fields

	private Long codigoLineaPedido;
	private ArticulosSmp articulosSmp;
	private PedidosSmp pedidosSmp;
	private Double precioUnidadArticulo;
	private Integer numeroUnidadesArticulo;
	private Double porcentajeDescuento;

	// Constructors

	/** default constructor */
	public LineaPedidoSmp() {
	}

	/** full constructor */
	public LineaPedidoSmp(ArticulosSmp articulosSmp, PedidosSmp pedidosSmp, Double precioUnidadArticulo,
			Integer numeroUnidadesArticulo, Double porcentajeDescuento) {
		this.articulosSmp = articulosSmp;
		this.pedidosSmp = pedidosSmp;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	// Property accessors

	public Long getCodigoLineaPedido() {
		return this.codigoLineaPedido;
	}

	public void setCodigoLineaPedido(Long codigoLineaPedido) {
		this.codigoLineaPedido = codigoLineaPedido;
	}

	public ArticulosSmp getArticulosSmp() {
		return this.articulosSmp;
	}

	public void setArticulosSmp(ArticulosSmp articulosSmp) {
		this.articulosSmp = articulosSmp;
	}

	public PedidosSmp getPedidosSmp() {
		return this.pedidosSmp;
	}

	public void setPedidosSmp(PedidosSmp pedidosSmp) {
		this.pedidosSmp = pedidosSmp;
	}

	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}

	public Integer getNumeroUnidadesArticulo() {
		return this.numeroUnidadesArticulo;
	}

	public void setNumeroUnidadesArticulo(Integer numeroUnidadesArticulo) {
		this.numeroUnidadesArticulo = numeroUnidadesArticulo;
	}

	public Double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}