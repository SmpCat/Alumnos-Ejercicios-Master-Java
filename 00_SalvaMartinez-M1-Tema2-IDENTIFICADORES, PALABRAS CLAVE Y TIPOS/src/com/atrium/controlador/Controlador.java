package com.atrium.controlador;

import java.text.DecimalFormat;

import com.atrium.modelo.*;
import com.atrium.vista.Vista;


public class Controlador {
	// PROPIEDADES DE CLASE
	private Monedas monedas;
	private Vista vista;
	private Double resto;
	private Tipos_Datos tipos_datos;
	private TestPersona testPersona;
	private DecimalFormat formato;

	/**
	 * Constructor sin argumentos.
	 */
	public Controlador() {
		// INSTANCIA DE PROPIEDADES DE CLASE
		monedas = new Monedas();
		vista = new Vista();
		tipos_datos = new Tipos_Datos();
		testPersona = new TestPersona();
		formato = new DecimalFormat("###,###.##");
		// LLAMADA A METODO DE ACCION

		gestionarCambio(163.27,200.00);
		gestionarVariables();
		testPersona.gestionarPersonas();
	}

	public void gestionarCambio(Double precio, Double pago) {
		// DEFINICION DE VARIABLE PARA EL CONTROL DEL FLUJO DE PROGRAMA
		this.resto = pago - precio;
		if (this.resto < 0) {
			vista.mostrar_Texto("El pago es insuficiente");
		}else if (this.resto == 0) {
			vista.mostrar_Texto("El cambio es " + formato.format(this.resto));
		}else if (this.resto > 0) {
			devolverCambio();
		}
	}
	
	public void devolverCambio() {
		vista.mostrar_Texto("El importe a devolver es: " + formato.format(this.resto));
		
		do {
			if (redondearDecimales(this.resto-Monedas.getB500(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB500()));
				this.resto = redondearDecimales(this.resto-Monedas.getB500(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB200(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB200()));
				this.resto = redondearDecimales(this.resto-Monedas.getB200(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB100(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB100()));
				this.resto = redondearDecimales(this.resto-Monedas.getB100(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB50(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB50()));
				this.resto = redondearDecimales(this.resto-Monedas.getB50(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB20(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB20()));
				this.resto = redondearDecimales(this.resto-Monedas.getB20(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB10(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB10()));
				this.resto = redondearDecimales(this.resto-Monedas.getB10(),2);
			}else if (redondearDecimales(this.resto-Monedas.getB5(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getB5()));
				this.resto = redondearDecimales(this.resto-Monedas.getB5(),2);
			}else if (redondearDecimales(this.resto-Monedas.getM2(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getM2()));
				this.resto = redondearDecimales(this.resto-Monedas.getM2(),2);
			}else if (redondearDecimales(this.resto-Monedas.getM1(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getM1()));
				this.resto = redondearDecimales(this.resto-Monedas.getM1(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC50(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC50()));
				this.resto = redondearDecimales(this.resto-Monedas.getC50(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC20(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC20()));
				this.resto = redondearDecimales(this.resto-Monedas.getC20(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC10(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC10()));
				this.resto = redondearDecimales(this.resto-Monedas.getC10(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC5(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC5()));
				this.resto = redondearDecimales(this.resto-Monedas.getC5(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC2(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC2()));
				this.resto = redondearDecimales(this.resto-Monedas.getC2(),2);
			}else if (redondearDecimales(this.resto-Monedas.getC1(), 2) >= 0) {
				vista.mostrar_Texto(formato.format(Monedas.getC1()));
				this.resto = redondearDecimales(this.resto-Monedas.getC1(),2);
			}
		} while (this.resto > 0);
	}
	
	public static Double redondearDecimales(Double valorInicial, Integer numeroDecimales) {
        Double parteEntera = new Double(0);
        Double resultado = new Double(0);
       
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=(double) Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
	
	public void gestionarVariables() {
		//Crear variables
		tipos_datos.setBoleano(true);
		tipos_datos.setCaracter('c');
		tipos_datos.setDecimal((float) 5.00);
		tipos_datos.setDecimal_grande(50.00);
		tipos_datos.setEntero(55);
		
		//Mostrar variables
		vista.mostrar_Texto("Variable de tipo " + tipos_datos.getBoleano().getClass() + " con valor " + tipos_datos.getBoleano());
		vista.mostrar_Texto("Variable de tipo " + tipos_datos.getCaracter().getClass() + " con valor " + tipos_datos.getCaracter());
		vista.mostrar_Texto("Variable de tipo " + tipos_datos.getDecimal().getClass() + " con valor " + tipos_datos.getDecimal());
		vista.mostrar_Texto("Variable de tipo " + tipos_datos.getDecimal_grande().getClass() + " con valor " + tipos_datos.getDecimal_grande());
		vista.mostrar_Texto("Variable de tipo " + tipos_datos.getEntero().getClass() + " con valor " + tipos_datos.getEntero());
	}
}
