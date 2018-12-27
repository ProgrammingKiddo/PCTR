  /**
   * Clase Trabajador1.
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Trabajador1 extends Thread {
    
    private Objeto reglas;
    private Objeto boli;
    
    //Constructor
    public Trabajador1(Objeto r, Objeto b) {
      reglas = r;
      boli = b;
    }

    //Código que ejecuta cada hilo
    public void run() {
      synchronized(reglas) {
        for(int i = 0; i < 100; ++i) {
          synchronized(boli) {
            System.out.println("===========");
          }
        }
      }
    }

  }
