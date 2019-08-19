package com.atrium.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase para Pedidos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Entity
@Table(name = "PEDIDOS_SSG")
public class Pedidos implements java.io.Serializable {

	/*** Serial Version */
	private static final long serialVersionUID = 1L;
	private Integer numeroPedido; 
	private Date fechaPedido; 
	private Double portePedido; 
	private Double seguroPedido; 
	private Double otrosCargosPedido; 
	private Double totalCargosPedido; 
	private Double totalBrutoPedido; 
	private Integer porcentajeIvaPedido; 
	private Double ivaPedido; 
	private Double totalFacturaPedido; 
	private Usuarios usuarios; 
	
	private Set<Linea_Pedido> lineaPedido = new HashSet<Linea_Pedido>(); 

	
	/** Constructor por defecto */
	public Pedidos() {
	}
	
	
	/** Constructor con PK */
	public Pedidos(Integer numeroPedido) {
		super();
		this.numeroPedido = numeroPedido;
	}

	/** Constructor con todos los parámetros */
	public Pedidos(Integer numeroPedido, Date fechaPedido, Double portePedido, Double seguroPedido,
			Double otrosCargosPedido, Double totalCargosPedido, Double totalBrutoPedido, Integer porcentajeIvaPedido,
			Double ivaPedido, Double totalFacturaPedido, Integer codigoCliente, Set<Linea_Pedido> lineaPedido, Usuarios usuarios) {
		super();
		this.numeroPedido = numeroPedido;
		this.fechaPedido = fechaPedido;
		this.portePedido = portePedido;
		this.seguroPedido = seguroPedido;
		this.otrosCargosPedido = otrosCargosPedido;
		this.totalCargosPedido = totalCargosPedido;
		this.totalBrutoPedido = totalBrutoPedido;
		this.porcentajeIvaPedido = porcentajeIvaPedido;
		this.ivaPedido = ivaPedido;
		this.totalFacturaPedido = totalFacturaPedido;
		this.lineaPedido = lineaPedido;
		this.usuarios = usuarios;
	}

	
	// Getters y Setters
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_generator")
	@SequenceGenerator(name="pedido_generator", sequenceName = "NUMERO_PEDIDO_SSG",  allocationSize = 1)
	@Column(name = "NUMERO_PEDIDO", unique = true, nullable = false)
	public Integer getNumeroPedido() {
		return this.numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PEDIDO", length = 7)
	public Date getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	@Column(name = "PORTE_PEDIDO", length = 11,  precision = 2)
	public Double getPortePedido() {
		return portePedido;
	}


	public void setPortePedido(Double portePedido) {
		this.portePedido = portePedido;
	}

	@Column(name = "SEGURO_PEDIDO", length = 11,  precision = 2)
	public Double getSeguroPedido() {
		return seguroPedido;
	}


	public void setSeguroPedido(Double seguroPedido) {
		this.seguroPedido = seguroPedido;
	}

	@Column(name = "OTROS_CARGOS_PEDIDO", length = 11,  precision = 2)
	public Double getOtrosCargosPedido() {
		return otrosCargosPedido;
	}


	public void setOtrosCargosPedido(Double otrosCargosPedido) {
		this.otrosCargosPedido = otrosCargosPedido;
	}

	@Column(name = "TOTAL_CARGOS_PEDIDO", length = 11,  precision = 2)
	public Double getTotalCargosPedido() {
		return totalCargosPedido;
	}


	public void setTotalCargosPedido(Double totalCargosPedido) {
		this.totalCargosPedido = totalCargosPedido;
	}
	
	@Column(name = "TOTAL_BRUTO_PEDIDO", length = 11,  precision = 2)
	public Double getTotalBrutoPedido() {
		return totalBrutoPedido;
	}

	
	public void setTotalBrutoPedido(Double totalBrutoPedido) {
		this.totalBrutoPedido = totalBrutoPedido;
	}
	
	@Column(name = "PORCENTAJE_IVA_PEDIDO", length = 2)
	public Integer getPorcentajeIvaPedido() {
		return porcentajeIvaPedido;
	}

	public void setPorcentajeIvaPedido(Integer porcentajeIvaPedido) {
		this.porcentajeIvaPedido = porcentajeIvaPedido;
	}

	@Column(name = "IVA_PEDIDO", length = 11, precision = 2)
	public Double getIvaPedido() {
		return ivaPedido;
	}

	
	public void setIvaPedido(Double ivaPedido) {
		this.ivaPedido = ivaPedido;
	}

	@Column(name = "TOTAL_FACTURA_PEDIDO", length = 11, precision = 2)
	public Double getTotalFacturaPedido() {
		return totalFacturaPedido;
	}


	public void setTotalFacturaPedido(Double totalFacturaPedido) {
		this.totalFacturaPedido = totalFacturaPedido;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedidos", orphanRemoval = true)
	public Set<Linea_Pedido> getLineaPedido(){
		return lineaPedido; 
	}
	
	public void setLineaPedido(Set<Linea_Pedido> lineaPedido) {
		this.lineaPedido = lineaPedido; 
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CLIENTE", nullable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}