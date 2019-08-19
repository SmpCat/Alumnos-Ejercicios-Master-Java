package com.atrium.modelo;

import java.sql.Date;

public class Datos_DAO_Formulario {

	private Datos_DTO_Formulario datos_DTO_Formulario;

	public Datos_DAO_Formulario() {
		datos_DTO_Formulario = new Datos_DTO_Formulario();
	}

	public Datos_DTO_Formulario leer_Datos_DTO_Formulario() {
		return datos_DTO_Formulario;
	}

	public void escribir_Datos_DTO_Formulario(Datos_DTO_Formulario datos_DTO_Formulario) {
		this.datos_DTO_Formulario.setNombre(datos_DTO_Formulario.getNombre());
		this.datos_DTO_Formulario.setPassword(datos_DTO_Formulario.getPassword());
		this.datos_DTO_Formulario.setCodigoRol(datos_DTO_Formulario.getCodigoRol());
		this.datos_DTO_Formulario.setFechaAlta(datos_DTO_Formulario.getFechaAlta());
		this.datos_DTO_Formulario.setFechaBaja(datos_DTO_Formulario.getFechaBaja());
		this.datos_DTO_Formulario.setCarpetaDocumentacion(datos_DTO_Formulario.getCarpetaDocumentacion());
		this.datos_DTO_Formulario.setIdioma(datos_DTO_Formulario.getIdioma());
	}
}
