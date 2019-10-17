/**
 * Programa en Java que lanza varios objetos comprobando si varias palabras son 
 * palíndromos.
 *
 * @author Natalia Partera
 * @version 2.0
 */

import java.util.concurrent.*;

public class UsaPalabraRun {
  public static void main (String[] args) {
    String[] palabras = new String[] {"casa", "ala", "ama", "oso", "leer", "sos"}; 
    int num = palabras.length;

    PalabraRun pal[] = new PalabraRun[num];
    ExecutorService exec = Executors.newSingleThreadExecutor();

    for(int i = 0; i < num; ++i) {
      pal[i] = new PalabraRun(palabras[i]);
      System.out.println("Palabra " + palabras[i] + " creada.");
      exec.execute(pal[i]);
    }
    exec.shutdown();
  }
}
