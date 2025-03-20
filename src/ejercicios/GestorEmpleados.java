package ejercicios;


import java.io.IOException;

import entrada.Teclado;

public class GestorEmpleados {
	
	public static void MenuOpciones() {

		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Crear un nuevo empleado y añadirlo a la colección");
		System.out.println("(2) Mostrar por consola la colección entera. ");
		System.out.println("(3) Eliminar un empleado por DNI.");
		System.out.println("(4) Guardar la colección entera en un archivo de texto");
		System.out.println("(5) Leer el archivo de texto empleados y cargar todos los objetos en la colección");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		int opcion;
		do {
			MenuOpciones();
			opcion = Teclado.leerEntero("Opcion?");
			String dni;
			int edad;
			double salario;
			Empleado empleado ;
			Empleado empleadoprueba = new Empleado("123D",34,400.45) ;
			switch (opcion) {

			case 0:
				break;
			case 1:
				dni = Teclado.leerCadena("Dni?");
				edad = Teclado.leerEntero("Edad?");
				salario = Teclado.leerReal("Salario?");

				empleado = new Empleado(dni, edad, salario);
				
				

				 boolean empleadoAgregado = Empleado.anyadirEmpleado(empleado);

				 if (empleadoAgregado) {
				     System.out.println("Empleado añadido con exito");
				 } else {
				     System.out.println("No se ha podido añadir el empleado");
				 }


				break;

			case 2:
				String resultado = empleadoprueba.obtenerEmpleados();
				System.out.println(resultado);
				break;

			case 3:
				dni = Teclado.leerCadena("Dni?");
				
				 boolean empleadoeliminado = Empleado.eliminarEmpleado(dni); ;

				 if (empleadoeliminado) {
				     System.out.println("Empleado eliminado  con exito");
				 } else {
				     System.out.println("No se ha podido eliminar el empleado");
				 }

				break;

			case 4:
				 try {
					 if(empleadoprueba.cargarDatosAFichero()) {
						 System.out.println("Se ha añadido al empleado");
					 }
					
				} catch (IOException e) {
				System.out.println("No se ha podido añadir al empleado");
				}
					
				
				break;

			case 5:
				 try {
					 if(empleadoprueba.descargarDatosDesdeFichero()) {
						 System.out.println("Se ha cargado los datos del archivo de texto empleados a la coleccion");
					 }
					
				} catch (IOException e) {
				System.out.println("No se ha podido cargar los datos");
				}

				break;

			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
			}
		} while (opcion != 0);
		System.out.println("Programa finalizado.");
	}


}

