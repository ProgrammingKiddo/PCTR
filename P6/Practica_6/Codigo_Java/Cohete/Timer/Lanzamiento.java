  /**
   * Clase Lanzamiento que simula la cuenta atrás del lanzamiento de un cohete.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;
  
  public class Lanzamiento {

    public static void main(String args[]) {
      Timer lanzamiento = new Timer();
      CuentaAtras apolo = new CuentaAtras(10, "Apolo");
      CuentaAtras soyuz = new CuentaAtras("Soyuz");
      long hora;
      boolean fin = false;

      hora = System.currentTimeMillis();
      lanzamiento.schedule(apolo, 2000, 1000);
      lanzamiento.schedule(soyuz, 15000, 1000);

      while(!fin) {
        if(System.currentTimeMillis() > hora + 60000) {
          System.out.println("Lanzamientos finalizados.");
          lanzamiento.cancel();
          fin = true;
        }
      }
    }
  }
