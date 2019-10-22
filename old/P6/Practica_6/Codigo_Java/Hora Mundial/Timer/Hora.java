  /**
   * Clase Hora que muestra la hora cuando los segundos valen 0.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;

  public class Hora extends TimerTask {
    private Calendar hora;
    private String ciudad;
    private int utc;

    Hora(String ciud, int utc) {
      this.ciudad = ciud;
      this.utc = utc;
    }

    public void run() {
      hora = Calendar.getInstance();
      while (System.currentTimeMillis() % 1000 != 0) {}
      hora = Calendar.getInstance();
      int offset = hora.get(Calendar.ZONE_OFFSET) + hora.get(Calendar.DST_OFFSET);
      offset = offset / 1000;
      offset = offset / 3600;
      hora.add(Calendar.HOUR_OF_DAY, -offset + utc);
      System.out.println(String.format(ciudad + ": %1$tH:%1$tM:%1$tS", hora));
    }
  }
