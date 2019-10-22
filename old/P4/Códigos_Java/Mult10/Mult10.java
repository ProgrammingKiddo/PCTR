/**
 * Clase que almacena un número y calcula sus 10 primeros múltiplos.
 *
 * @author Natalia Partera
 * @version 1.0
 */

import java.lang.*;

public class Mult10 implements Runnable {
  int numero;

  Mult10() {}
  Mult10(int num) {
    numero = num;
  }

  public void run() {
    for(int i = 0; i < 10; ++i) {
      System.out.println(numero + " * " + i + " = " + (numero * i) );
    }
  }
}
