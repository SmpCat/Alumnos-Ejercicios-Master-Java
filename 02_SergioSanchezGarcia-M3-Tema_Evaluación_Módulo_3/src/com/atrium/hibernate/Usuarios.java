package com.atrium.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase para Usuarios
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Entity
@Table(name = "USUARIOS_SSG")
public class Usuarios implements java.io.Serializable {

	// Fields


	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String password;
	private Date fechaAltaUsuario;
	private Date fechaBajaUsuario;
	private String codUsuario;
	private String idioma; 
	private String dni;
	private String emailUsuario;
	private Set<Pedidos> pedidos = new HashSet<Pedidos>(0);

	// Constructors

	/** Constructor por defecto */
	public Usuarios() {
	}

	/**  constructor Minimo*/
	public Usuarios(String codUsuario, String nombreUsuario,
			String idioma) {
		this.codUsuario = codUsuario;
		this.nombreUsuario = nombreUsuario;
		this.idioma = idioma;
	}

	/** Contructor entero */
	
	public Usuarios(String nombreUsuario, String password, Date fechaAltaUsuario, Date fechaBajaUsuario,
			String codUsuario, String idioma, String dni, String emailCliente , Set<Pedidos> pedidos) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.fechaAltaUsuario = fechaAltaUsuario;
		this.fechaBajaUsuario = fechaBajaUsuario;
		this.codUsuario = codUsuario;
		this.idioma = idioma;
		this.dni = dni;
		this.emailUsuario = emailCliente;
		this.pedidos = pedidos;
	}
	
	// Property accessors
	@Id
	@Column(name = "COD_USUARIO", unique = true, nullable = false)
	public String getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	@Column(name = "NOMBRE_USUARIO", nullable = false, length = 35)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "DNI", length = 10)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ALTA", length = 7)
	public Date getFechaAltaUsuario() {
		return this.fechaAltaUsuario;
	}

	public void setFechaAltaUsuario(Date fechaAltaUsuario) {
		this.fechaAltaUsuario = fechaAltaUsuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_BAJA", length = 7)
	public Date getFechaBajaUsuario() {
		return this.fechaBajaUsuario;
	}

	public void setFechaBajaUsuario(Date fechaBajaUsuario) {
		this.fechaBajaUsuario = fechaBajaUsuario;
	}

	@Column(name = "IDIOMA", length = 40)
	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Column(name = "EMAIL", length = 35)
	public String getEmailCliente() {
		return this.emailUsuario;
	}

	public void setEmailCliente(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Pedidos> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	
}