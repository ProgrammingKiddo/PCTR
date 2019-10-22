  /**
   * Clase relojes que muestra la hora en diferentes ciudades cada minuto.
   * 
   * @author Natalia Partera
   * @version 2.0
   */

  import java.util.concurrent.*;
  import java.util.*;

  public class Relojes {

    public static void main(String args[]) {

//      ScheduledThreadPoolExecutor relojes = new ScheduledThreadPoolExecutor(5);
      ScheduledExecutorService relojes = Executors.newScheduledThreadPool(5);
      Hora madrid = new Hora("Madrid", 2);
      Hora londres = new Hora("Londres", 1);
      Hora paris = new Hora("París", 2);
      Hora berlin = new Hora("Berlín", 2);
      Hora tokio = new Hora("Tokio", 9);

      relojes.scheduleAtFixedRate(madrid, 0, 1, TimeUnit.SECONDS);
      relojes.scheduleAtFixedRate(londres, 0, 1, TimeUnit.SECONDS);
      relojes.scheduleAtFixedRate(paris, 0, 1, TimeUnit.SECONDS);
      relojes.scheduleAtFixedRate(berlin, 0, 1, TimeUnit.SECONDS);
      relojes.scheduleAtFixedRate(tokio, 0, 1, TimeUnit.SECONDS);

    }
  }
