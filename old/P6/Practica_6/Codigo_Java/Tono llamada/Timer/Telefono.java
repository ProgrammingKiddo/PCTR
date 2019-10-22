  /**
   * Clase Telefono que utiliza objetos de la clase Tono para avisar de una llamada.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;
  import java.io.*;

  public class Telefono {

    public static void main(String args[]) throws IOException {
      Timer telefono = new Timer();
      Tono ring = new Tono();
      Tono ring2 = new Tono("ring ring");
      Tono grito = new Tono("¡Coge el teléfono!");
      Tono bip = new Tono("bip");
      Tono bip2 = new Tono("biip");
      Tono bip3 = new Tono("biiip");
      int fin = 'n';

      System.out.println("Para parar una llamada, introduzca ''q''.");
      System.out.println();

      System.out.println("Llamada 1:");
      telefono.schedule(ring, 3000, 1000);

      do {
        fin = System.in.read();
        System.out.println();
      } while (fin != 'q');
      ring.cancel();

      System.out.println("Llamada 2:");
      telefono.schedule(ring2, 3000, 1000);
      telefono.schedule(grito, 5500, 2000);

      do {
        fin = System.in.read();
        System.out.println();
      } while (fin != 'q');
      ring2.cancel();
      grito.cancel();

      System.out.println("Llamada 3:");
      telefono.schedule(bip, 3000, 1500);
      telefono.schedule(bip2, 5000, 2000);
      telefono.schedule(bip3, 5500, 2000);

      do {
        fin = System.in.read();
        System.out.println();
      } while (fin != 'q');
      telefono.cancel();
    }

  }
