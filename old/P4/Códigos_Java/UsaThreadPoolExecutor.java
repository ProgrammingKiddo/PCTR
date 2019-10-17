/**
 * Programa de prueba para ilustrar el uso de la clase ThreadPoolExecutor.
 *
 * @author Natalia Partera
 * @version 1.0
 */

import java.util.concurrent.*;
import java.util.*;

public class UsaThreadPoolExecutor
{
  public static void main(String[] args)
  {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Introduzca el número de tareas a ejecutar: ");
    int nTasks = teclado.nextInt();
    System.out.print("Introduzca el número de hilos que tendrá la reserva de hilos: ");
    int tpSize = teclado.nextInt();

    ThreadPoolExecutor tpe = new ThreadPoolExecutor(tpSize, tpSize, 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    Task[] tasks = new Task[nTasks];
    for(int i = 0; i < nTasks; ++i) {
      tasks[i] = new Task(i);
      System.out.println("Tarea " + i + " a ejecutar.");
      tpe.execute(tasks[i]);
    }
    tpe.shutdown();
  }
}
