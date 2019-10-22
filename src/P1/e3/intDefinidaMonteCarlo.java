/*
 * @author: Borja
 */

package P1.e3;

import java.util.Scanner;


public class intDefinidaMonteCarlo{




	public static void main(String[] args){

		Scanner keyboardScanner;
		int numeroDeIntentos, hits;
		double aproximacion;

		System.out.print("Introduzca el número de intentos que quiere utilizar para calcular la aproximación\na la integral: ");
		keyboardScanner = new Scanner(System.in);
		numeroDeIntentos = keyboardScanner.nextInt();

		hits = calcularHits(numeroDeIntentos);

		
		aproximacion = (double) hits / numeroDeIntentos;

		System.out.println("La aproximación por el método de MonteCarlo para " + numeroDeIntentos + " iteraciones es: " + aproximacion + ".");
		keyboardScanner.close();
	}


	private static int calcularHits(int numeroDeIntentos){

		int hits, i;
		double xPos, yPos;

		hits = 0;
		i = 0;

		for(i = 0; i < numeroDeIntentos; i++){
			xPos = Math.random();
			yPos = Math.random();

			if(yPos < function(xPos)){
				hits++;
			}
		}

		return hits;
	}


	private static double function(double xCoord){

		return Math.sin(xCoord);

	}

	/*
	 * private static double function(double xCoord){
	 *		
	 *		return xCoord;
	 * }
	 */
}
