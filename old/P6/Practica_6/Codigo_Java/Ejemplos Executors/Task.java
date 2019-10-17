  /**
   * Clase Task que representa una tarea que puede ser ejecutada concurrentemente.
   *
   * @author Natalia Partera
   * @version 1.0
   */

  public class Task implements Runnable {
    private int id;

    public Task() {}
    public Task(int id) {
      this.id = id;
    }

    public void run() {
      System.out.println("Ejecutando tarea " + id);
      for (int i = 0; i < 100; ++i) {}
      System.out.println("Fin de la tarea " + id);
    }
  }
