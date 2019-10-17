  /**
   * Clase reloj que muestra la hora cada segundo.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;
  import java.io.*;

  public class Reloj {

    public static void main(String args[]) {

      Timer reloj = new Timer();
      Minuto hora = new Minuto();

      reloj.scheduleAtFixedRate(hora, 100, 1000);

    }
  }
