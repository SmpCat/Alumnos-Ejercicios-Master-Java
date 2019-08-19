package com.atrium.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedidos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PEDIDOS")
public class Pedidos implements java.io.Serializable {

	// Fields

	private Integer numeroPedido;
	private Clientes clientes;
	private Date fechaPedido;
	private Double portePedido;
	private Double seguroPedido;
	private Double otrosCargosPedido;
	private Double totalCargosPedido;
	private Double totalBrutoPedido;
	private Byte porcentajeIvaPedido;
	private Double ivaPedido;
	private Double totalFacturaPedido;
	private Set<LineaPedido> lineaPedidos = new HashSet<LineaPedido>(0);

	// Constructors

	/** default constructor */
	public Pedidos() {
	}

	/** minimal constructor */
	public Pedidos(Integer numeroPedido, Clientes clientes) {
		this.numeroPedido = numeroPedido;
		this.clientes = clientes;
	}

	/** full constructor */
	public Pedidos(Integer numeroPedido, Clientes clientes, Date fechaPedido,
			Double portePedido, Double seguroPedido, Double otrosCargosPedido,
			Double totalCargosPedido, Double totalBrutoPedido,
			Byte porcentajeIvaPedido, Double ivaPedido,
			Double totalFacturaPedido, Set<LineaPedido> lineaPedidos) {
		this.numeroPedido = numeroPedido;
		this.clientes = clientes;
		this.fechaPedido = fechaPedido;
		this.portePedido = portePedido;
		this.seguroPedido = seguroPedido;
		this.otrosCargosPedido = otrosCargosPedido;
		this.totalCargosPedido = totalCargosPedido;
		this.totalBrutoPedido = totalBrutoPedido;
		this.porcentajeIvaPedido = porcentajeIvaPedido;
		this.ivaPedido = ivaPedido;
		this.totalFacturaPedido = totalFacturaPedido;
		this.lineaPedidos = lineaPedidos;
	}

	// Property accessors
	@Id
	@Column(name = "NUMERO_PEDIDO", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getNumeroPedido() {
		return this.numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CLIENTE", nullable = false)
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PEDIDO", length = 7)
	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	@Column(name = "PORTE_PEDIDO", precision = 11)
	public Double getPortePedido() {
		return this.portePedido;
	}

	public void setPortePedido(Double portePedido) {
		this.portePedido = portePedido;
	}

	@Column(name = "SEGURO_PEDIDO", precision = 11)
	public Double getSeguroPedido() {
		return this.seguroPedido;
	}

	public void setSeguroPedido(Double seguroPedido) {
		this.seguroPedido = seguroPedido;
	}

	@Column(name = "OTROS_CARGOS_PEDIDO", precision = 11)
	public Double getOtrosCargosPedido() {
		return this.otrosCargosPedido;
	}

	public void setOtrosCargosPedido(Double otrosCargosPedido) {
		this.otrosCargosPedido = otrosCargosPedido;
	}

	@Column(name = "TOTAL_CARGOS_PEDIDO", precision = 11)
	public Double getTotalCargosPedido() {
		return this.totalCargosPedido;
	}

	public void setTotalCargosPedido(Double totalCargosPedido) {
		this.totalCargosPedido = totalCargosPedido;
	}

	@Column(name = "TOTAL_BRUTO_PEDIDO", precision = 11)
	public Double getTotalBrutoPedido() {
		return this.totalBrutoPedido;
	}

	public void setTotalBrutoPedido(Double totalBrutoPedido) {
		this.totalBrutoPedido = totalBrutoPedido;
	}

	@Column(name = "PORCENTAJE_IVA_PEDIDO", precision = 2, scale = 0)
	public Byte getPorcentajeIvaPedido() {
		return this.porcentajeIvaPedido;
	}

	public void setPorcentajeIvaPedido(Byte porcentajeIvaPedido) {
		this.porcentajeIvaPedido = porcentajeIvaPedido;
	}

	@Column(name = "IVA_PEDIDO", precision = 11)
	public Double getIvaPedido() {
		return this.ivaPedido;
	}

	public void setIvaPedido(Double ivaPedido) {
		this.ivaPedido = ivaPedido;
	}

	@Column(name = "TOTAL_FACTURA_PEDIDO", precision = 11)
	public Double getTotalFacturaPedido() {
		return this.totalFacturaPedido;
	}

	public void setTotalFacturaPedido(Double totalFacturaPedido) {
		this.totalFacturaPedido = totalFacturaPedido;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedidos")
	public Set<LineaPedido> getLineaPedidos() {
		return this.lineaPedidos;
	}

	public void setLineaPedidos(Set<LineaPedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

}