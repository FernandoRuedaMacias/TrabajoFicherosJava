package ejercicios;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	
	
	private String dni;
	private int edad;
	private double salario;
	static  List<Empleado> ColeccionEmpleados = new ArrayList<>();
	static String ruta = "C:\\Users\\frsna\\Desktop\\GRADO SUPERIOR\\PROGRAMACION\\Ficheros\\empleados.txt";
	



	
	public Empleado(String dni, int edad, double salario) {
		this.dni = dni;
		this.edad = edad;
		this.salario = salario;
	}
	
	public Empleado(String cadena) {
		
		String[] vectorAtributos = cadena.split(";");
		this.edad = Integer.parseInt(vectorAtributos[2]);
		this.dni = vectorAtributos[0];
		this.salario = Double.parseDouble((vectorAtributos[1]).replace(",", "."));
	}
	
	


	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", edad=" + edad + ", salario=" + salario + "]";
	}
	
	
	public String obtenerJSON() {
		String json = "";
		json = json+"{"+dni+";"+edad+";"+String.format("%.2f", salario).replace(",", ".")+"}";
		return json;
	}
	
	public  static boolean anyadirEmpleado(Empleado Empleado) {
		for (Empleado emple : ColeccionEmpleados) {
			if (emple.getDni().equals(Empleado.getDni())) {
				return  false;
			}
			
			}
		ColeccionEmpleados.add(Empleado);
		return true;

		}

		
	

	public static  boolean eliminarEmpleado(String dni) {
		for (Empleado emple : ColeccionEmpleados) {
			if (emple.getDni().equals(dni)) {
				ColeccionEmpleados.remove(emple);
				return  true;
			}
				
			}
		return false;

		

		}

	public String obtenerEmpleados() {
		String Empleados = "";
		for (Empleado emple : ColeccionEmpleados) {
			Empleados = Empleados + "[" + emple.toString() + "]" + "\n";
		}

		return Empleados;
	}
	

	public boolean cargarDatosAFichero() throws IOException {
		boolean cargaCorrecta = true;
		BufferedWriter escritor = null;
		try {
			escritor = new BufferedWriter(new FileWriter(ruta));
			for (Empleado emple : ColeccionEmpleados) {
				escritor.write(emple.obtenerJSON());
				escritor.newLine();
			}
		} catch (IOException ioe) {
			cargaCorrecta = false;
		} finally {
			if (escritor != null) {
				escritor.close();
			}
		}
		return cargaCorrecta;
	}
	
	
	public boolean descargarDatosDesdeFichero() throws IOException {
		
		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader(ruta));
			String estadosFormateados = "";
			estadosFormateados = lector.readLine();
			estadosFormateados = obtenerJSON();
			
			while ((estadosFormateados = lector.readLine()) != null) {
				Empleado.anyadirEmpleado(new Empleado(estadosFormateados));

			}

		} catch (IOException ioe) {
			if (lector != null) {
				lector.close();

			}
			return false;
		}

		return true;
	}
	


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	

}

