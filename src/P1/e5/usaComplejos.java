/*
 * @author: Borja
 * @version: 1.0
 */

package P1.e5;
import java.util.Scanner;


public class usaComplejos{

	static Scanner keyboardScanner = new Scanner(System.in);

	public static void main(String[] args){

		gestionarMenu();
	}

	

	private static void gestionarMenu(){

		int operacion;

		operacion = 0;

		while(operacion == 0){
			mostrarMenu();
			operacion = elegirOperacion();
		}
		ejecutarOperacion(operacion);

	}


	private static void mostrarMenu(){

		System.out.println("Elija una de las siguientes operaciones para trabajar con complejos:"
							+ "\n\t1)Suma\n\t2)Resta\n\t3)Multiplicación"
							+ "\n\t4)División\n\t5)Módulo");

	}

	public static int elegirOperacion(){

		int input;
		
		input = 0;
		do{
			input = keyboardScanner.nextInt();
			if(input < 1 || input > 5){
				System.out.println("\bIntroduzca una operación correcta.");
			}
		} while(input < 1 || input > 5);

		return input;
	}

	/*
	 * @param: entero 'operacion' con valor entre 1 y 5
	 */
	public static void ejecutarOperacion(int operacion){


		switch(operacion){

			case 1:
				suma();
				break;

			case 2:
				resta();
				break;

			case 3:
				producto();
				break;

			case 4:
				cociente();
				break;

			case 5:
				modulo();
				break;

			default:
				System.err.println("Se ha producido un error al seleccionar la operación.");

		}
	}


	private static void suma(){

		Complejos sumandoA, sumandoB, suma;

		sumandoA = getComplejo();
		sumandoB = getComplejo();

		suma = sumandoA.sumaComplejos(sumandoB);

		System.out.println("\nLa suma de los complejos " + sumandoA.toString() +
						" y " + sumandoB.toString() + " da como resultado el complejo " +
						suma.toString() + ".");
	}

	private static void resta(){

		Complejos minuendo, sustraendo, diferencia;

		minuendo = getComplejo();
		sustraendo = getComplejo();

		diferencia = minuendo.restaComplejos(sustraendo);

		System.out.println("\nLa diferencia de los complejos " + minuendo.toString() +
		" y " + sustraendo.toString() + " da como resultado el complejo " +
		diferencia.toString() + ".");
	}

	private static void producto(){

		Complejos factorA, factorB, producto;

		factorA = getComplejo();
		factorB = getComplejo();

		producto = factorA.productoComplejos(factorB);

		System.out.println("\nEl producto de los complejos " + factorA.toString() +
		" y " + factorB.toString() + " da como resultado el complejo " +
		producto.toString() + ".");
	}

	private static void cociente(){

		Complejos dividendo, divisor, cociente;

		dividendo = getComplejo();
		divisor = getComplejo();

		cociente = dividendo.cocienteComplejos(divisor);

		System.out.println("\nEl cociente de los complejos " + dividendo.toString() +
		" y " + divisor.toString() + " da como resultado el complejo " +
		cociente.toString() + ".");
	}

	private static void modulo(){

		Complejos complejo;

		complejo = getComplejo();

		System.out.println("\nEl módulo del complejo " + complejo.toString() +
							" es " + complejo.modulo() + ".");
	}

	private static Complejos getComplejo(){

		float parteReal, parteImaginaria;
		Complejos complejo;

		System.out.println("Debe crear un número complejo.");

		do{
			System.out.print("Introduzca la parte real del complejo: ");
			parteReal = keyboardScanner.nextFloat();
		}while(Float.isNaN(parteReal));

		do{
			System.out.print("Introduzca la parte imaginaria del complejo: ");
			parteImaginaria = keyboardScanner.nextFloat();
		}while(Float.isNaN(parteImaginaria));

		complejo = new Complejos(parteReal, parteImaginaria);
		System.out.println("Ok! Ha creado con éxito el complejo " + complejo.toString() + ".\n");

		return complejo;
	}



}
