package com.atrium.modelo;

import java.sql.Date;

public class Datos_DTO_Formulario {
	private String nombre;
	private String password;
	private String codigoRol;
	private String fechaAlta;
	private String fechaBaja;
	private String carpetaDocumentacion;
	private String idioma;

	public Datos_DTO_Formulario() {
		nombre = new String();
		password = new String();
		codigoRol = new String();
		fechaAlta = new String();
		fechaBaja = new String();
		carpetaDocumentacion = new String();
		idioma = new String();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getCarpetaDocumentacion() {
		return carpetaDocumentacion;
	}

	public void setCarpetaDocumentacion(String carpetaDocumentacion) {
		this.carpetaDocumentacion = carpetaDocumentacion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}