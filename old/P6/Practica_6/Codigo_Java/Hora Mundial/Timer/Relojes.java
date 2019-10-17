  /**
   * Clase relojes que muestra la hora en diferentes ciudades cada minuto.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;
  import java.io.*;

  public class Relojes {

    public static void main(String args[]) {

      Timer relojes = new Timer();
      Hora madrid = new Hora("Madrid", 2);
      Hora londres = new Hora("Londres", 1);
      Hora paris = new Hora("París", 2);
      Hora berlin = new Hora("Berlín", 2);
      Hora tokio = new Hora("Tokio", 9);

      relojes.scheduleAtFixedRate(madrid, 100, 5000);
      relojes.scheduleAtFixedRate(londres, 200, 5000);
      relojes.scheduleAtFixedRate(paris, 300, 5000);
      relojes.scheduleAtFixedRate(berlin, 400, 5000);
      relojes.scheduleAtFixedRate(tokio, 500, 5000);

    }
  }
