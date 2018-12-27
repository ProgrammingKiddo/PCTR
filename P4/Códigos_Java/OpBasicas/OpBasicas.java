/**
 * Clase que representa almacena un par de números y realiza operaciones básicas 
 * entre ellos.
 *
 * @author Natalia Partera
 * @version 1.0
 */

import java.lang.*;

public class OpBasicas extends Thread {
  int x, y;

  OpBasicas() {}
  OpBasicas(int num1, int num2) {
    x = num1;
    y = num2;
  }

  public void run() {
    System.out.println(x + " + " + y + " = " + (x + y) );
    System.out.println(x + " - " + y + " = " + (x - y) );
    System.out.println(x + " * " + y + " = " + (x * y) );
    System.out.println(x + " / " + y + " = " + (x / y) );
  }
}
