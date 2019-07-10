package com.atrium.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ejemplo de definicion de tipos de datos en Java y el uso de los metodos de
 * conversion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 26-9-2016.
 *
 */
public class Tipos_Datos {
	// PROPIEDADES DE CLASE
	// TEXTO
	private String texto;
	private Character caracter;
	// NUMERICOS
	private Byte entero_pequeño;
	private Short entero_corto;
	private Integer entero;
	private Long entero_grande;
	private Float decimal;
	private Double decimal_grande;
	// NUMERICOS ESPECIALES
	private BigInteger especial_entero;
	private BigDecimal especial_decimal;
	// LOGICOS
	private Boolean boleano;
	// FECHA-HORA
	private Date fecha_hora;
	

	//Métodos getters y setters
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Character getCaracter() {
		return caracter;
	}
	public void setCaracter(Character caracter) {
		this.caracter = caracter;
	}
	public Byte getEntero_pequeño() {
		return entero_pequeño;
	}
	public void setEntero_pequeño(Byte entero_pequeño) {
		this.entero_pequeño = entero_pequeño;
	}
	public Short getEntero_corto() {
		return entero_corto;
	}
	public void setEntero_corto(Short entero_corto) {
		this.entero_corto = entero_corto;
	}
	public Integer getEntero() {
		return entero;
	}
	public void setEntero(Integer entero) {
		this.entero = entero;
	}
	public Long getEntero_grande() {
		return entero_grande;
	}
	public void setEntero_grande(Long entero_grande) {
		this.entero_grande = entero_grande;
	}
	public Float getDecimal() {
		return decimal;
	}
	public void setDecimal(Float decimal) {
		this.decimal = decimal;
	}
	public Double getDecimal_grande() {
		return decimal_grande;
	}
	public void setDecimal_grande(Double decimal_grande) {
		this.decimal_grande = decimal_grande;
	}
	public BigInteger getEspecial_entero() {
		return especial_entero;
	}
	public void setEspecial_entero(BigInteger especial_entero) {
		this.especial_entero = especial_entero;
	}
	public BigDecimal getEspecial_decimal() {
		return especial_decimal;
	}
	public void setEspecial_decimal(BigDecimal especial_decimal) {
		this.especial_decimal = especial_decimal;
	}
	public Boolean getBoleano() {
		return boleano;
	}
	public void setBoleano(Boolean boleano) {
		this.boleano = boleano;
	}
	public Date getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}	
}
