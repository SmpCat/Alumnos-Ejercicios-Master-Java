package com.atrium.modelo;

public class Area {

	private int base;
	private int altura;
	private double radio;
	private static final double PI = 3.1416;
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public int calcularAreaRectangulo (int base, int altura) {
		return base * altura;
	}
	
	public double calcularAreaCirculo (double radio) {
		return PI * Math.pow(radio,2);
	}
}		
