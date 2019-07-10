package com.atrium.controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * EJERCICIO 4 Crear un programa que genere un fichero llamado texto.txt en la
 * unidad D: con la información escrita por el usuario.
 * 
 */

public class Ejercicio4 {

	public static void main(String[] args) {
		InputStreamReader flujo_lector = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo_lector);
		try {
			FileWriter flujo_escritura = new FileWriter("D:\\texto.txt");
			BufferedWriter buffer_escritura = new BufferedWriter(flujo_escritura);
			System.out.println("Escribe el texto a guardar ");
			buffer_escritura.write(teclado.readLine());
			buffer_escritura.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
