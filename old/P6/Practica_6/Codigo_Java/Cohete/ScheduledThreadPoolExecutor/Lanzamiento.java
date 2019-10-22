  /**
   * Clase Lanzamiento que simula la cuenta atrás del lanzamiento de un cohete.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.concurrent.*;
  import java.util.*;
  
  public class Lanzamiento {

    public static void main(String args[]) {
      ScheduledThreadPoolExecutor lanzadera = new ScheduledThreadPoolExecutor(2);
      CuentaAtras apolo = new CuentaAtras(10, "Apolo");
      CuentaAtras soyuz = new CuentaAtras("Soyuz");
      long hora;
      boolean fin = false;

      hora = System.currentTimeMillis();
      lanzadera.scheduleWithFixedDelay(apolo, 1, 1, TimeUnit.SECONDS);
      lanzadera.scheduleWithFixedDelay(soyuz, 15, 1, TimeUnit.SECONDS);

      while(!fin) {
        if(System.currentTimeMillis() > hora + 60000) {
          System.out.println("Lanzamientos finalizados.");
          lanzadera.shutdown();
          fin = true;
        }
      }
    }
  }
