  /**
   * Clase Trabajador.
   * [Ejercicio]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Trabajador extends Thread {
    private String nombre;
    private Objeto objeto1;
    private Objeto objeto2;
    
    //Constructor
    public Trabajador(String n, Objeto obj1, Objeto obj2) {
      nombre = n;
      objeto1 = obj1;
      objeto2 = obj2;
    }

    //Código que ejecuta cada hilo
    public void run() {
      synchronized(objeto1) {
        for(int i = 0; i < 5000; ++i) {
          synchronized(objeto2) {
            if(i%100 == 0)
              System.out.println(nombre + ": ===========");
          }
        }
      }
    }

  }
