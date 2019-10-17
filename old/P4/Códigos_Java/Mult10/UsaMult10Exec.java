  /**
   * Programa en Java que crea y lanza varios hilos utilizando la clase Mult10.
   *
   * @author Natalia Partera
   * @version 2.0
   */

  import java.util.concurrent.*;

  public class UsaMult10Exec {
    public static void main (String[] args) {

      int[] nums = new int[] {45, 320, 887, 11, 2398, 402, 674, 3057, 1823, 5956};
      int numTareas = nums.length;

      ExecutorService exec = Executors.newSingleThreadExecutor();

      Mult10[] tareas = new Mult10[numTareas];
      for(int i = 0; i < numTareas; ++i) {
        tareas[i] = new Mult10(nums[i]);
        System.out.println("Tarea " + i + " creada.");
        exec.execute(tareas[i]);
      }
      exec.shutdown();
    }
  }
