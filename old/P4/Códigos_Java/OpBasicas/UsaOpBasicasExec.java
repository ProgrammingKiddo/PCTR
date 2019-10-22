/**
 * Programa en Java que lanza varios hilos realizando operaciones básicas entre
 * dos números.
 *
 * @author Natalia Partera
 * @version 2.0
 */

import java.util.*;
import java.util.concurrent.*;

public class UsaOpBasicasExec {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);
    int x = 3, y = 8;

    System.out.println("Indique cuántas tareas quiere ejecutar: ");
    int numTareas = teclado.nextInt();
    System.out.println("Indique cuántos hilos quiere crear: ");
    int numHilos = teclado.nextInt();

    ExecutorService exec = Executors.newFixedThreadPool(numHilos);

    OpBasicasExec[] tareas = new OpBasicasExec[numTareas];
    for(int i = 0; i < numTareas; ++i) {
      x = 3;
      y = 8;
      tareas[i] = new OpBasicasExec(x * (i+1), y * (i+1));
      System.out.println("Tarea " + i + " creada.");
      exec.execute(tareas[i]);
    }
    exec.shutdown();
  }
}
