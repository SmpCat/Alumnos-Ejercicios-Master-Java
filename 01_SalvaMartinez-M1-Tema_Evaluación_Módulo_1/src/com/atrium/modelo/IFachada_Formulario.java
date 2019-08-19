package com.atrium.modelo;

import java.sql.Date;

public interface IFachada_Formulario {

	// DEFINICION DE LA FIRMA DE LOS METODOS A MOSTRAR
	public Datos_DTO_Formulario leer_Datos_DTO_Formulario();

	public void escribir_Datos_DTO_Formulario(Datos_DTO_Formulario datos_DTO_Formulario);
}
