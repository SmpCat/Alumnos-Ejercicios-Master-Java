package com.atrium.modelo;

import java.sql.Date;

/**
 *
 * FACHADA = FACADE
 * LA FACHADA SE ENCARGA DE INSTANCIAR AL DAO
 * DENTRO DE LA FACHADA TENDRÉ TANTOS MÉTODOS COMO MÉTODOS TENGA EL DAO 
 * LA FACHADA HACE DE INTERMEDIARIA ENTRE EL DAO Y EL RESTO DE COMPONENTES DE LA APLICACIÓN
 * 
 * @author smpca
 *
 */

public class Fachada_Formulario implements IFachada_Formulario {

	private Datos_DAO_Formulario datos_DAO_Formulario;

	public Fachada_Formulario() {
		datos_DAO_Formulario = new Datos_DAO_Formulario();
	}

	public Datos_DTO_Formulario leer_Datos_DTO_Formulario() {
		return datos_DAO_Formulario.leer_Datos_DTO_Formulario();
	}

	public void escribir_Datos_DTO_Formulario(Datos_DTO_Formulario datos_DTO_Formulario) {
		datos_DAO_Formulario.escribir_Datos_DTO_Formulario(datos_DTO_Formulario);
	}

}
