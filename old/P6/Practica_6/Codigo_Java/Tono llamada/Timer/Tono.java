  /**
   * Clase Tono que representa una tono de llamada.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;

  public class Tono extends TimerTask {
    private String sonido;

    Tono() {
      sonido = new String("riiing");
    }

    Tono(String son) {
      sonido = new String(son);
    }

    public void run() {
      System.out.println(sonido);
    }
  }
