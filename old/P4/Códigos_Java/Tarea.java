/**
 * Clase Tarea que imprime varias veces su nombre al ser ejecutada.
 *
 * @author Natalia Partera
 * @version 1.0
 */


  public class Tarea extends Thread {
    private int id;

    public Tarea() {}
    public Tarea(int id) {
      this.id = id;
    }

    public void run() {
      String name = getName();
      for(int i = 0; i < 15; ++i) {
        System.out.println("Vuelta " + i + " de " + name + " ");
      }
    }
  }
