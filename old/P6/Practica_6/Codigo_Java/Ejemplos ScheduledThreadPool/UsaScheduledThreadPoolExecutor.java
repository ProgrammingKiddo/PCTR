  /**
   * Programa de prueba para ilustrar el uso de la clase ScheduledThreadPoolExecutor.
   *
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.concurrent.*;
  import java.util.*;

  public class UsaScheduledThreadPoolExecutor {
    public static void main(String[] args) 
    {
      Scanner teclado = new Scanner(System.in);

      System.out.print("Introduzca el número de hilos que tendrá el thread pool: ");
      int numHilos = teclado.nextInt();

      ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(numHilos);

      Task t1 = new Task(1);
      Task t2 = new Task(2);
      Task t3 = new Task(3);
      Task t4 = new Task(4);

      //La tarea t1 se ejecutará inmediatamente.
      stpe.execute(t1);
      //La tarea t2 comenzará dentro de 3 segundos.
      stpe.schedule(t2, 3, TimeUnit.SECONDS);
      //La tarea t3 comenzará dentro de 5 segundos y se repetirá cada 8 segundos.
      stpe.scheduleAtFixedRate(t3, 5, 8, TimeUnit.SECONDS);
      //La tarea t4 comenzará dentro de 15 segundos y se repetirá a un intervalo 
      //constante de 3 segundos.
      stpe.scheduleWithFixedDelay(t4, 15, 3, TimeUnit.SECONDS);
    }
  }
