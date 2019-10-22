/**
 * Programa de prueba para ilustrar el uso de la clase Executors.
 *
 * @author Natalia Partera
 * @version 3.0
 */

import java.util.concurrent.*;
import java.util.*;

public class UsaExecutors
{
  public static void main(String[] args)
  {
    Scanner teclado = new Scanner(System.in);
//    ExecutorService exec = Executors.newCachedThreadPool();
    ExecutorService exec = Executors.newSingleThreadExecutor();

    System.out.print("Introduzca el número de tareas a ejecutar: ");
    int nTasks = teclado.nextInt();
//    System.out.print("Introduzca el número de hilos que tendrá la reserva de hilos: ");
//    int tpSize = teclado.nextInt();

//    ExecutorService exec = Executors.newFixedThreadPool(tpSize);

    Task[] tasks = new Task[nTasks];
    for(int i = 0; i < nTasks; ++i) {
      tasks[i] = new Task(i);
      System.out.println("Tarea " + i + " a ejecutar.");
      exec.execute(tasks[i]);
    }
    exec.shutdown();
  }
}
