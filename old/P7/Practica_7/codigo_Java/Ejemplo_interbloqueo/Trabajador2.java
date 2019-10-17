  /**
   * Clase Trabajador2.
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Trabajador2 extends Thread {
    
    private Objeto reglas;
    private Objeto boli;

    //Constructor
    public Trabajador2(Objeto r, Objeto b) {
      reglas = r;
      boli = b;
    }

    //Código que ejecuta cada hilo
    public void run() {
      synchronized(boli) {
        for(int i = 0; i < 100; ++i) {
          synchronized(reglas) {
            System.out.println("------------");
          }
        }
      }
    }

  }
