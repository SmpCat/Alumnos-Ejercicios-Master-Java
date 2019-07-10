package com.atrium.controlador;

import java.io.File;

/**
 *
 * EJERCICIO 1 Crear un programa que muestre la lista de ficheros y directorios
 * del directorio: C:\windows
 * 
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		int i;
		File directorio = new File("C:\\windows");
		String[] lista = directorio.list();
		for (i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
}
