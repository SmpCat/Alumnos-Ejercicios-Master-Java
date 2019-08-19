package com.atrium.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase Atículos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Entity
@Table(name = "ARTICULOS_SSG")
public class Articulos implements java.io.Serializable {

	// Fields

	/*** Serial Version */
	private static final long serialVersionUID = 1L;

	private Integer codigoArticulo;
	private String descripcionArticulo; 
	private Double precioUnidadArticulo; 
	private Integer cantidad; 

	private Set<Linea_Pedido> lineaPedidos = new HashSet<Linea_Pedido>(0); 
	// Constructors

	/** Constructor por defecto */
	public Articulos() {
	}
	
	/** Constructor con PK */
	public Articulos(Integer codigoArticulo) {
		super();
		this.codigoArticulo = codigoArticulo;
	}

	
	/** Constructor con todos los parámetros */
	public Articulos(Integer codigoArticulo, String descripcionArticulo, Double precioUnidadArticulo, Integer cantidad, 
			Set<Linea_Pedido> lineaPedidos) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.descripcionArticulo = descripcionArticulo;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.cantidad = cantidad; 
		this.lineaPedidos = lineaPedidos; 
	}


	// GETERS AND SETTERS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articulo_generator")
	@SequenceGenerator(name="articulo_generator", sequenceName = "CODIGO_ARTICULO_SSG", allocationSize = 1)
	@Column(name = "CODIGO_ARTICULO", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	@Column(name = "DESCRIPCION_ARTICULO", length = 40)
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	
	@Column(name = "PRECIO_UNIDAD_ARTICULO", length = 11, precision = 2)
	public Double getPrecioUnidadArticulo() {
		return precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}
	
	@Column(name = "CANTIDAD", length = 5)
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulos")
	public Set<Linea_Pedido> getLineaPedidos() {
		return lineaPedidos;
	}

	public void setLineaPedidos(Set<Linea_Pedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

}