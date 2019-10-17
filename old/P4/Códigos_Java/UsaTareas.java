/**
 * Programa de prueba para la clase Tarea.
 *
 * @author Natalia Partera
 * @version 3.0
 */

import java.util.concurrent.*;
import java.util.*;

public class UsaTareas
{
  public static void main(String[] args)
  {
    Scanner teclado = new Scanner(System.in);
//    ExecutorService exec = Executors.newCachedThreadPool();
    ExecutorService exec = Executors.newSingleThreadExecutor();

    System.out.print("Introduzca el número de tareas a ejecutar: ");
    int numTareas = teclado.nextInt();
//    System.out.print("Introduzca el número de hilos que tendrá la reserva de hilos: ");
//    int tpSize = teclado.nextInt();

//    ExecutorService exec = Executors.newFixedThreadPool(tpSize);

    Tarea[] tareas = new Tarea[numTareas];
    for(int i = 0; i < numTareas; ++i) {
      tareas[i] = new Tarea();
      System.out.println("Tarea " + i + " a ejecutar.");
      exec.execute(tareas[i]);
    }
    exec.shutdown();
  }
}
