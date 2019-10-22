/*
 * @author: Borja
 */

import java.util.Scanner;

public class NewtonRaphson {

	
	public static void main(String[] args) {
		
		int numeroDeAproximaciones, funcion;
		double aproximacionInicial, aproximacionFinal;
		
		funcion = getFuncion();
		numeroDeAproximaciones = getNumeroDeAproximaciones();
		aproximacionInicial = getAproximacionInicial(funcion);
		
		if(funcion == 1) {
			aproximacionFinal = aproximacionFuncion1(aproximacionInicial, numeroDeAproximaciones);
		}
		else {
			aproximacionFinal = aproximacionFuncion2(aproximacionInicial, numeroDeAproximaciones);
		}
		
		System.out.println("El cero estimado de la función " + funcion + " mediante el método de Newton-Raphson, para " +
						numeroDeAproximaciones + " aproximaciones es: " + aproximacionFinal + ".");

	}
	
	/****************************/
	/*		PRIVATE METHODS		*/
	/****************************/
	
	private static int getFuncion() {
		
		Scanner scannerTeclado;
		int funcion;
		
		scannerTeclado = new Scanner(System.in);
		
		do {
			System.out.print("Seleccione la función sobre la que aplicar el método de Newton-Raphson:" +
					"\n\t1) f(x) = cos(x) - x^3  (en el espacio [0, 1])\n\t2) f(x) = x^2 - 5  (en el espacio [2, 3])" +
					"\nOpción: ");
			funcion = scannerTeclado.nextInt();
		} while(funcion != 1 && funcion != 2);
		
		//scannerTeclado.close();
		return funcion;
	}


	private static int getNumeroDeAproximaciones() {
		
		Scanner scannerTeclado;
		int aproximaciones;
		
		scannerTeclado = new Scanner(System.in);
		
		do {
			System.out.print("Introduzca el número de aproximaciones que se deben hacer para calcular\n" + 
								"el cero de la función: ");
			aproximaciones = scannerTeclado.nextInt();
			if(aproximaciones <= 0) {
				System.out.println("Por favor, introduzca un número válido de aproximaciones para el cálculo.");
			}
		} while(aproximaciones <= 0);
		
		//scannerTeclado.close();
		
		return aproximaciones;
	}
	
	private static double getAproximacionInicial(int funcion) {
		
		Scanner scannerTeclado;
		double aproximacionInicial;
		int valorMin, valorMax;
		
		scannerTeclado = new Scanner(System.in);
		valorMin = (funcion == 1) ?0 :2;
		valorMax = valorMin + 1;
		
		do {
			System.out.print("Introduzca la aproximación inicial desde la que se debe empezar a calcular\n" + 
					"el cero de la función: ");
			aproximacionInicial = scannerTeclado.nextDouble();
			if(aproximacionInicial < valorMin || aproximacionInicial > valorMax) {
				System.out.println("Por favor, introduzca una aproximación inicial dentro del espacio válido ["
									+ valorMin + ", " + valorMax+ "] para el cálculo.");
			}
		} while(aproximacionInicial < valorMin || aproximacionInicial > valorMax);


		scannerTeclado.close();
		
		return aproximacionInicial;
	}
	
	
	private static double aproximacionFuncion1(double aproximacionAnterior, int numeroDeAproximaciones) {
		
		int i;
		double aproximacionActual;
		
		aproximacionActual = 0;
		i = 0;
		
		while(i < numeroDeAproximaciones) {
			aproximacionActual = aproximacionAnterior - funcion1(aproximacionAnterior) / derivadaFuncion1(aproximacionAnterior);
			aproximacionAnterior = aproximacionActual;
			i++;
		}
		
		return aproximacionActual;
	}
	
	private static double aproximacionFuncion2(double aproximacionAnterior, int numeroDeAproximaciones) {
		
		int i;
		double aproximacionActual;
		
		aproximacionActual = 0;
		i = 0;
		
		while(i < numeroDeAproximaciones) {
			aproximacionActual = aproximacionAnterior - funcion2(aproximacionAnterior) / derivadaFuncion2(aproximacionAnterior);
			aproximacionAnterior = aproximacionActual;
			i++;
		}
		
		return aproximacionActual;
	}
	
	
	private static double funcion1(double x) {
		
		double y;
		
		y = Math.cos(x) - Math.pow(x, 3);
		
		return y;
	}
	
	private static double derivadaFuncion1(double x) {
		
		double y;
		
		y = -3 * Math.pow(x, 2) - Math.sin(x);
		
		return y;
	}
	
	private static double funcion2(double x) {
		
		double y;
		
		y = Math.pow(x, 2) - 5;
		
		return y;
	}
	
	private static double derivadaFuncion2(double x) {
		
		double y;
		
		y = 2 * x;
		
		return y;
	}
	
}
