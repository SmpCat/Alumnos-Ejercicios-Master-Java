package com.atrium.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * EJERCICIO 3 Crear un programa que introduciendo el nombre de un fichero (con
 * su ruta completa) nos de toda la información posible de él.
 * 
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		String texto;
		InputStreamReader flujo_lector = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo_lector);
		try {
			System.out.println("Introduce fichero con ruta completa ");
			texto = teclado.readLine();
			File fichero = new File(texto);
			System.out.println("Nombre: " + fichero.getName());
			System.out.println("Directorio " + fichero.getPath());
			if (fichero.exists())
				System.out.println("El fichero existe ");
			if (fichero.canWrite())
				System.out.println("Se puede escribir ");
			if (fichero.canRead())
				System.out.println("Se puede leer ");
			System.out.println("El tamaño es: " + fichero.length() + " bytes");
			System.out.println("La ultima modificacion es: " + fichero.lastModified());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
