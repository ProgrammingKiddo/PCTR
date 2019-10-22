  /**
   * Clase Minuto que muestra la hora cuando los milisegundos valen 0.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;

  public class Minuto extends TimerTask {
    private Calendar hora;

    Minuto() {}

    public void run() {
      hora = Calendar.getInstance();
      while (System.currentTimeMillis() % 1000 != 0) {}
      hora = Calendar.getInstance();
      System.out.println(String.format("%1$tH:%1$tM:%1$tS %1$tL", hora));
    }
  }
