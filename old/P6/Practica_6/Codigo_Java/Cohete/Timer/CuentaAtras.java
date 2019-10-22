  /**
   * Clase CuentaAtras que representa la cuenta atrás para el lanzamiento de un cohete.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;

  public class CuentaAtras extends TimerTask {
    private int segundos;
    private String cohete;

    CuentaAtras(String nave) {
      segundos = 30;
      cohete = nave;
    }

    CuentaAtras(int seg, String nave) {
      segundos = seg;
      cohete = nave;
    }

    public void run() {
      if(segundos > 0) {
        System.out.println(cohete + ": " + segundos);
        --segundos;
      }
      else if (segundos == 0) {
        System.out.println("Lanzamiento de la nave " + cohete);
        cancel();
      }
    }

  }
