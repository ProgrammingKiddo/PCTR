/**
 * Clase que representa a una palabra y comprueba si es palíndromo.
 *
 * @author Natalia Partera
 * @version 1.0
 */

import java.lang.*;

public class Palabra extends Thread {
  String palabra;

  Palabra() {}
  Palabra(String pal) {
    palabra = pal;
  }

  public void run() {
    boolean palindromo = true;
    int i = 0;
    int j = palabra.length() - 1;

    while(palindromo && i < j) {
      if(palabra.charAt(i) == palabra.charAt(j)) {
        ++i;
        --j;
      }
      else
        palindromo = false;
    }
    if(palindromo)
      System.out.println("La palabra " + palabra + " es un palíndromo.");
    else
      System.out.println("La palabra " + palabra + " no es un palíndromo.");
  }
}
