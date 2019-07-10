package com.atrium.modelo;

import java.text.DecimalFormat;

public class Persona {
	// PROPIEDADES DE CLASE
	private String nombre;
	private Integer edad;
	// METODOS CONSTRUCTORES
	public Persona(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	// METODOS PROPIEDADES
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	// METODOS DE LA CLASE
	public String calcularEdad() {
		DecimalFormat formato = new DecimalFormat("###,###");
		Integer dias = new Integer(0);
		Integer segundos = new Integer(0);
		String resultado = new String();
		dias = this.edad * 365;
		segundos = dias * 24 * 60 * 60;
		resultado = this.nombre + " tiene " + this.edad + " años que equivalen a " + formato.format(dias) + " dias o a " + formato.format(segundos) + " segundos";
		return resultado;
	}
}
