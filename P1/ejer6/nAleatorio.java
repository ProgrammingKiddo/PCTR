/*
 * @author: Borja
 */

import java.util.Scanner;
import java.lang.*;


public class nAleatorio {

  public static void main(String[] args){

    Scanner keyboardScanner;
	int iteraciones, i;

	System.out.print("Introduzca la cantidad de números primos que desea generar: ");
	keyboardScanner = new Scanner(System.in);
	iteraciones = keyboardScanner.nextInt();

	keyboardScanner.close();

    for(i = 0; i < iteraciones; i++){
      System.out.println("Elemento nº" + (i+1) + ": " + Math.random());
    }
  }

}
