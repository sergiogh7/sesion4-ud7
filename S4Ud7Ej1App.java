import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * App que pide nombre de alumnos
 * Version 1.0
 * @author Sergio Galimany Hoyo
 */
public class S4Ud7Ej1App {

	public static void main(String[] args) {
		
		// Declara Scanner.
		Scanner teclado = new Scanner(System.in);
		
		// Declara el ArrayList.
		ArrayList<String> listado = new ArrayList<>();
		
		// Variables.
		String nombreAlumno = "";
		int numeroAlumnos;
		int nota1 = 0;
		int nota2 = 0;
		int nota3 = 0;
		int notaMedia = 0;
		int contadorAlumnos = 1;
		
		// Pide el numero de alumnos si pone menos de 0.
		do {
			
			String inputNumeroAlumnos = JOptionPane.showInputDialog("¿Cuantos alumnos va a evaluar?");
			numeroAlumnos = Integer.parseInt(inputNumeroAlumnos);
			
		}while(numeroAlumnos < 0);
		
		// Si hay mas de 0 alumnos.
		if(numeroAlumnos > 0) {
		
			// Va pidiendo hasta que no queden alumnos.
			for (int i = 0; i < numeroAlumnos; i++) {
				
				// Pide el nombre del alumno.
				nombreAlumno = JOptionPane.showInputDialog("Escriba el nombre del alumno " +contadorAlumnos+ " :");
				
				// Pide las 3 notas de las UF.
				String inputNota1 = JOptionPane.showInputDialog("Escriba la nota de UF1:");
				nota1 = Integer.parseInt(inputNota1);
				
				String inputNota2 = JOptionPane.showInputDialog("Escriba la nota de UF2:");
				nota2 = Integer.parseInt(inputNota2);
				
				String inputNota3 = JOptionPane.showInputDialog("Escriba la nota de UF3:");
				nota3 = Integer.parseInt(inputNota3);
	
				// Calcula la nota media.
				notaMedia = (nota1 + nota2 + nota3) / 3;
				
				// Suma 1 al contador de alumnos.
				contadorAlumnos ++;
				
				// Añade los datos al ArrayList.
				listado.add( "Alumno: " + nombreAlumno + "\nNota media: " + notaMedia + "\n");
				
			}
	
			
			// Recorre el ArrayList y printa los valores que hay en cada posicion.
			for (int i = 0; i < listado.size(); i++) {
				
				System.out.println(listado.get(i));
				
			}
		
		// Si el usuario introduce 0 alumnos a evaluar.
		}else {
			JOptionPane.showMessageDialog(null, "No hay alumnos que evaluar.");
		}

	}

}
