package com.atrium.modelo;

public class Datos_DAO_Properties {

	private Datos_DTO_Properties datos_DTO_Properties;

	public Datos_DAO_Properties() {
		datos_DTO_Properties = new Datos_DTO_Properties();
	}

	public Datos_DTO_Properties leer_Datos_DTO_Properties() {
		return datos_DTO_Properties;
	}

	public void escribir_Datos_DTO_Properties(Datos_DTO_Properties datos_DTO_Properties) {
		this.datos_DTO_Properties.setList(datos_DTO_Properties.getList());
	}
}
