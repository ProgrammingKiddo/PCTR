  /**
   * Código de ejemplo para ilustrar el funcionamiento de la clase Timer.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;
  
  public class MiTimer {

    public static void main(String args[]) {
      Timer miTimer = new Timer();
      MiTimerTask mt1 = new MiTimerTask();
      MiTimerTask mt2 = new MiTimerTask(52);
      MiTimerTask mt3 = new MiTimerTask(77);
      MiTimerTask mt4 = new MiTimerTask(103);

      System.out.println("Pulse Ctrl + Z para detener el programa.");
      miTimer.schedule(mt1, 200);
      miTimer.schedule(mt2, 800);
      miTimer.schedule(mt3, 1500, 3000);
      miTimer.scheduleAtFixedRate(mt4, 2000, 4500);

    }
  }
