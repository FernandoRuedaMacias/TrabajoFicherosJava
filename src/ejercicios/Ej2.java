package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entrada.Teclado;
//C:\\Users\\frsna\\Desktop\\GRADO SUPERIOR\\PROGRAMACION\\Ficheros\\hola.txt

public class Ej2 {

	public static void main(String[] args) {
		boolean check = true;
		File ar = null;
		BufferedReader lector = null;
		String[] Vectorpalabras = null;
		int contador = 0;
		String linea;
		String palabra;
		String palabralarga = "";
		do {
			String ruta = Teclado.leerCadena("Ruta del archivo?");

			if (ruta.endsWith(".txt")) {
				check = true;
				ar = new File(ruta);
				try {
					lector = new BufferedReader(new FileReader(ruta));
					linea = lector.readLine();
					while (linea != null) {
						Vectorpalabras = linea.split("\\s");
						for (int i = 0; i < Vectorpalabras.length; i++) {
							palabra = Vectorpalabras[i];
							contador++;
							if (palabra.length() > palabralarga.length()) {
								palabralarga = palabra;
							}

						}
						linea = lector.readLine();
					}
					System.out.println("Se han leído " + contador + " palabras  del fichero de texto.");
					System.out.println("La palabra de mayor longitud es " + palabralarga);
					lector.close();

					if (contador == 0) {
						System.out.println("No se pudo leer el fichero porque esta vacio o corrupto");
						lector.close();
					}

				} catch (IOException e) {
					System.out.println("Archivo no encontrado");
				}

			} else {
				System.out.println("La ruta de archivo tiene que terminar en .txt");
				check = false;
			}

		} while (check != true);

	}

}