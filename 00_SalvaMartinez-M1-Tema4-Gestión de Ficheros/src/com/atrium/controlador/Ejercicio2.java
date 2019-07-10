package com.atrium.controlador;

import java.io.File;

/**
 *
 * EJERCICIO 2 Crear un programa que muestre la lista de volúmenes.
 * 
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		File lista[] = File.listRoots();
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i] + " ");
		}
	}
}
