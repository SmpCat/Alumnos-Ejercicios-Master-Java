package com.atrium.controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * EJERCICIO 5 Crear un programa que genere una copia de seguridad de un
 * fichero.
 * 
 */

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {

		String fichero, leido;
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo);

		System.out.println("Introduce fichero a copiar ");
		fichero = teclado.readLine();

		FileReader flujo_lector = new FileReader("D:\\" + fichero);
		BufferedReader buffer_lector = new BufferedReader(flujo_lector);
		FileWriter flujo_escritura = new FileWriter("D:\\copiaSeguridad.txt");
		BufferedWriter buffer_escritura = new BufferedWriter(flujo_escritura);
		// TEXTO LEIDO EN CADA OPERACION
		leido = buffer_lector.readLine();
		// ACUMULACION DE TODO EL TEXTO LEIDO
		StringBuffer acumulacion_leido = new StringBuffer();
		// PROCESO REPETITVO DE LECTURA HASTA FIN DE FICHERO
		// LECTURA HASTA EL INTRO (O CUALQUIER OTRO CARACTER EN FUNCION
		// DEL OPERATIVO
		while (leido != null) {
			acumulacion_leido.append(leido + System.getProperty("line.separator"));
			leido = buffer_lector.readLine();
		}
		// ESCRIBIMOS TODO EL TEXTO EN UN SOLA LLAMADA AL METODO
		buffer_escritura.write(acumulacion_leido.toString());
		// CERRAMOS
		buffer_lector.close();
		buffer_escritura.close();
	}
}
