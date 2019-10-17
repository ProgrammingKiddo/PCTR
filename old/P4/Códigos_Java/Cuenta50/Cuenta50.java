/**
 * Clase que almacena un número y cuenta 50 a partir de él.
 *
 * @author Natalia Partera
 * @version 1.0
 */

import java.lang.*;

public class Cuenta50 implements Runnable {
  int numero;

  Cuenta50() {}
  Cuenta50(int num) {
    numero = num;
  }

  public void run() {
    for(int i = 0; i < 50; ++i) {
      System.out.println(numero + " + " + i + " = " + (numero + i) );
    }
  }
}
