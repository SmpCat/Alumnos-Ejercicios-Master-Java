package com.atrium.modelo;

import com.atrium.vista.Formulario;

/**
*
* FACHADA = FACADE
* LA FACHADA SE ENCARGA DE INSTANCIAR AL DAO
* DENTRO DE LA FACHADA TENDR� TANTOS M�TODOS COMO M�TODOS TENGA EL DAO 
* LA FACHADA HACE DE INTERMEDIARIA ENTRE EL DAO Y EL RESTO DE COMPONENTES DE LA APLICACI�N
* 
* @author smpca
*
*/

public class Fachada_Properties implements IFachada_Properties {

	private Datos_DAO_Properties datos_DAO_Properties;

	public Fachada_Properties() {
		datos_DAO_Properties = new Datos_DAO_Properties();
	}

	public Datos_DTO_Properties leer_Datos_DTO_Properties() {
		return datos_DAO_Properties.leer_Datos_DTO_Properties();
	}

	public void escribir_Datos_DTO_Properties(Datos_DTO_Properties datos_DTO_Properties) {
		datos_DAO_Properties.escribir_Datos_DTO_Properties(datos_DTO_Properties);
	}
}
