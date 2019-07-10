package com.atrium.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clientes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENTES")
public class Clientes implements java.io.Serializable {

	// Fields

	private Integer codigoCliente;
	private String nombreCliente;
	private String tipoEmpresa;
	private String cifCliente;
	private String nifCliente;
	private String nombreComercialCliente;
	private Date fechaAltaCliente;
	private Date fechaBajaCliente;
	private String calleCliente;
	private String ciudadCliente;
	private String cpCliente;
	private String provinciaCliente;
	private String telefonoCliente;
	private String faxCliente;
	private String emailCliente;
	private String contadoCliente;
	private String creditoCliente;
	private Double cifraVentasCliente;
	private Double beneficiosCliente;
	private String prepagoCliente;
	private Double capitalCliente;
	private Double inmovilizadoCliente;
	private Double pasivoCliente;
	private Double activoCliente;
	private Date añoBalanceCliente;
	private Double limiteCliente;
	private Double pendienteCliente;
	private Double restoCliente;
	private String calleEnvioCliente;
	private String ciudadEnvioCliente;
	private String cpEnvioCliente;
	private String provinciaEnvioCliente;
	private String telefonoEnvioCliente;
	private String faxEnvioCliente;
	private String emailEnvioCliente;
	private String observacionesCliente;
	private String estadoCliente;
	private Set<Pedidos> pedidoses = new HashSet<Pedidos>(0);

	// Constructors

	/** default constructor */
	public Clientes() {
	}

	/** minimal constructor */
	public Clientes(Integer codigoCliente, String nombreCliente,
			String estadoCliente) {
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.estadoCliente = estadoCliente;
	}

	/** full constructor */
	public Clientes(Integer codigoCliente, String nombreCliente,
			String tipoEmpresa, String cifCliente, String nifCliente,
			String nombreComercialCliente, Date fechaAltaCliente,
			Date fechaBajaCliente, String calleCliente, String ciudadCliente,
			String cpCliente, String provinciaCliente, String telefonoCliente,
			String faxCliente, String emailCliente, String contadoCliente,
			String creditoCliente, Double cifraVentasCliente,
			Double beneficiosCliente, String prepagoCliente,
			Double capitalCliente, Double inmovilizadoCliente,
			Double pasivoCliente, Double activoCliente, Date añoBalanceCliente,
			Double limiteCliente, Double pendienteCliente, Double restoCliente,
			String calleEnvioCliente, String ciudadEnvioCliente,
			String cpEnvioCliente, String provinciaEnvioCliente,
			String telefonoEnvioCliente, String faxEnvioCliente,
			String emailEnvioCliente, String observacionesCliente,
			String estadoCliente, Set<Pedidos> pedidoses) {
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.tipoEmpresa = tipoEmpresa;
		this.cifCliente = cifCliente;
		this.nifCliente = nifCliente;
		this.nombreComercialCliente = nombreComercialCliente;
		this.fechaAltaCliente = fechaAltaCliente;
		this.fechaBajaCliente = fechaBajaCliente;
		this.calleCliente = calleCliente;
		this.ciudadCliente = ciudadCliente;
		this.cpCliente = cpCliente;
		this.provinciaCliente = provinciaCliente;
		this.telefonoCliente = telefonoCliente;
		this.faxCliente = faxCliente;
		this.emailCliente = emailCliente;
		this.contadoCliente = contadoCliente;
		this.creditoCliente = creditoCliente;
		this.cifraVentasCliente = cifraVentasCliente;
		this.beneficiosCliente = beneficiosCliente;
		this.prepagoCliente = prepagoCliente;
		this.capitalCliente = capitalCliente;
		this.inmovilizadoCliente = inmovilizadoCliente;
		this.pasivoCliente = pasivoCliente;
		this.activoCliente = activoCliente;
		this.añoBalanceCliente = añoBalanceCliente;
		this.limiteCliente = limiteCliente;
		this.pendienteCliente = pendienteCliente;
		this.restoCliente = restoCliente;
		this.calleEnvioCliente = calleEnvioCliente;
		this.ciudadEnvioCliente = ciudadEnvioCliente;
		this.cpEnvioCliente = cpEnvioCliente;
		this.provinciaEnvioCliente = provinciaEnvioCliente;
		this.telefonoEnvioCliente = telefonoEnvioCliente;
		this.faxEnvioCliente = faxEnvioCliente;
		this.emailEnvioCliente = emailEnvioCliente;
		this.observacionesCliente = observacionesCliente;
		this.estadoCliente = estadoCliente;
		this.pedidoses = pedidoses;
	}

	// Property accessors
	@Id
	@Column(name = "CODIGO_CLIENTE", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Column(name = "NOMBRE_CLIENTE", nullable = false, length = 35)
	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@Column(name = "TIPO_EMPRESA", length = 1)
	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	@Column(name = "CIF_CLIENTE", length = 10)
	public String getCifCliente() {
		return this.cifCliente;
	}

	public void setCifCliente(String cifCliente) {
		this.cifCliente = cifCliente;
	}

	@Column(name = "NIF_CLIENTE", length = 10)
	public String getNifCliente() {
		return this.nifCliente;
	}

	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	@Column(name = "NOMBRE_COMERCIAL_CLIENTE", length = 40)
	public String getNombreComercialCliente() {
		return this.nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ALTA_CLIENTE", length = 7)
	public Date getFechaAltaCliente() {
		return this.fechaAltaCliente;
	}

	public void setFechaAltaCliente(Date fechaAltaCliente) {
		this.fechaAltaCliente = fechaAltaCliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_BAJA_CLIENTE", length = 7)
	public Date getFechaBajaCliente() {
		return this.fechaBajaCliente;
	}

	public void setFechaBajaCliente(Date fechaBajaCliente) {
		this.fechaBajaCliente = fechaBajaCliente;
	}

	@Column(name = "CALLE_CLIENTE", length = 40)
	public String getCalleCliente() {
		return this.calleCliente;
	}

	public void setCalleCliente(String calleCliente) {
		this.calleCliente = calleCliente;
	}

	@Column(name = "CIUDAD_CLIENTE", length = 35)
	public String getCiudadCliente() {
		return this.ciudadCliente;
	}

	public void setCiudadCliente(String ciudadCliente) {
		this.ciudadCliente = ciudadCliente;
	}

	@Column(name = "CP_CLIENTE", length = 5)
	public String getCpCliente() {
		return this.cpCliente;
	}

	public void setCpCliente(String cpCliente) {
		this.cpCliente = cpCliente;
	}

	@Column(name = "PROVINCIA_CLIENTE", length = 35)
	public String getProvinciaCliente() {
		return this.provinciaCliente;
	}

	public void setProvinciaCliente(String provinciaCliente) {
		this.provinciaCliente = provinciaCliente;
	}

	@Column(name = "TELEFONO_CLIENTE", length = 9)
	public String getTelefonoCliente() {
		return this.telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	@Column(name = "FAX_CLIENTE", length = 9)
	public String getFaxCliente() {
		return this.faxCliente;
	}

	public void setFaxCliente(String faxCliente) {
		this.faxCliente = faxCliente;
	}

	@Column(name = "EMAIL_CLIENTE", length = 35)
	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Column(name = "CONTADO_CLIENTE", length = 1)
	public String getContadoCliente() {
		return this.contadoCliente;
	}

	public void setContadoCliente(String contadoCliente) {
		this.contadoCliente = contadoCliente;
	}

	@Column(name = "CREDITO_CLIENTE", length = 1)
	public String getCreditoCliente() {
		return this.creditoCliente;
	}

	public void setCreditoCliente(String creditoCliente) {
		this.creditoCliente = creditoCliente;
	}

	@Column(name = "CIFRA_VENTAS_CLIENTE", precision = 11)
	public Double getCifraVentasCliente() {
		return this.cifraVentasCliente;
	}

	public void setCifraVentasCliente(Double cifraVentasCliente) {
		this.cifraVentasCliente = cifraVentasCliente;
	}

	@Column(name = "BENEFICIOS_CLIENTE", precision = 11)
	public Double getBeneficiosCliente() {
		return this.beneficiosCliente;
	}

	public void setBeneficiosCliente(Double beneficiosCliente) {
		this.beneficiosCliente = beneficiosCliente;
	}

	@Column(name = "PREPAGO_CLIENTE", length = 1)
	public String getPrepagoCliente() {
		return this.prepagoCliente;
	}

	public void setPrepagoCliente(String prepagoCliente) {
		this.prepagoCliente = prepagoCliente;
	}

	@Column(name = "CAPITAL_CLIENTE", precision = 11)
	public Double getCapitalCliente() {
		return this.capitalCliente;
	}

	public void setCapitalCliente(Double capitalCliente) {
		this.capitalCliente = capitalCliente;
	}

	@Column(name = "INMOVILIZADO_CLIENTE", precision = 11)
	public Double getInmovilizadoCliente() {
		return this.inmovilizadoCliente;
	}

	public void setInmovilizadoCliente(Double inmovilizadoCliente) {
		this.inmovilizadoCliente = inmovilizadoCliente;
	}

	@Column(name = "PASIVO_CLIENTE", precision = 11)
	public Double getPasivoCliente() {
		return this.pasivoCliente;
	}

	public void setPasivoCliente(Double pasivoCliente) {
		this.pasivoCliente = pasivoCliente;
	}

	@Column(name = "ACTIVO_CLIENTE", precision = 11)
	public Double getActivoCliente() {
		return this.activoCliente;
	}

	public void setActivoCliente(Double activoCliente) {
		this.activoCliente = activoCliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AÑO_BALANCE_CLIENTE", length = 7)
	public Date getAñoBalanceCliente() {
		return this.añoBalanceCliente;
	}

	public void setAñoBalanceCliente(Date añoBalanceCliente) {
		this.añoBalanceCliente = añoBalanceCliente;
	}

	@Column(name = "LIMITE_CLIENTE", precision = 11)
	public Double getLimiteCliente() {
		return this.limiteCliente;
	}

	public void setLimiteCliente(Double limiteCliente) {
		this.limiteCliente = limiteCliente;
	}

	@Column(name = "PENDIENTE_CLIENTE", precision = 11)
	public Double getPendienteCliente() {
		return this.pendienteCliente;
	}

	public void setPendienteCliente(Double pendienteCliente) {
		this.pendienteCliente = pendienteCliente;
	}

	@Column(name = "RESTO_CLIENTE", precision = 11)
	public Double getRestoCliente() {
		return this.restoCliente;
	}

	public void setRestoCliente(Double restoCliente) {
		this.restoCliente = restoCliente;
	}

	@Column(name = "CALLE_ENVIO_CLIENTE", length = 40)
	public String getCalleEnvioCliente() {
		return this.calleEnvioCliente;
	}

	public void setCalleEnvioCliente(String calleEnvioCliente) {
		this.calleEnvioCliente = calleEnvioCliente;
	}

	@Column(name = "CIUDAD_ENVIO_CLIENTE", length = 30)
	public String getCiudadEnvioCliente() {
		return this.ciudadEnvioCliente;
	}

	public void setCiudadEnvioCliente(String ciudadEnvioCliente) {
		this.ciudadEnvioCliente = ciudadEnvioCliente;
	}

	@Column(name = "CP_ENVIO_CLIENTE", length = 5)
	public String getCpEnvioCliente() {
		return this.cpEnvioCliente;
	}

	public void setCpEnvioCliente(String cpEnvioCliente) {
		this.cpEnvioCliente = cpEnvioCliente;
	}

	@Column(name = "PROVINCIA_ENVIO_CLIENTE", length = 35)
	public String getProvinciaEnvioCliente() {
		return this.provinciaEnvioCliente;
	}

	public void setProvinciaEnvioCliente(String provinciaEnvioCliente) {
		this.provinciaEnvioCliente = provinciaEnvioCliente;
	}

	@Column(name = "TELEFONO_ENVIO_CLIENTE", length = 9)
	public String getTelefonoEnvioCliente() {
		return this.telefonoEnvioCliente;
	}

	public void setTelefonoEnvioCliente(String telefonoEnvioCliente) {
		this.telefonoEnvioCliente = telefonoEnvioCliente;
	}

	@Column(name = "FAX_ENVIO_CLIENTE", length = 9)
	public String getFaxEnvioCliente() {
		return this.faxEnvioCliente;
	}

	public void setFaxEnvioCliente(String faxEnvioCliente) {
		this.faxEnvioCliente = faxEnvioCliente;
	}

	@Column(name = "EMAIL_ENVIO_CLIENTE", length = 35)
	public String getEmailEnvioCliente() {
		return this.emailEnvioCliente;
	}

	public void setEmailEnvioCliente(String emailEnvioCliente) {
		this.emailEnvioCliente = emailEnvioCliente;
	}

	@Lob
	@Column(name = "OBSERVACIONES_CLIENTE")
	public String getObservacionesCliente() {
		return this.observacionesCliente;
	}

	public void setObservacionesCliente(String observacionesCliente) {
		this.observacionesCliente = observacionesCliente;
	}

	@Column(name = "ESTADO_CLIENTE", nullable = false, length = 2)
	public String getEstadoCliente() {
		return this.estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set<Pedidos> getPedidoses() {
		return this.pedidoses;
	}

	public void setPedidoses(Set<Pedidos> pedidoses) {
		this.pedidoses = pedidoses;
	}

}