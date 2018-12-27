/**
 * Programa en Java que lanza varios objetos comprobando si varias palabras son 
 * palíndromos.
 *
 * @author Natalia Partera
 * @version 1.0
 */


public class UsaPalabraRun {
  public static void main (String[] args) throws InterruptedException {
    Runnable pal1 = new Palabra("casa");
    Runnable pal2 = new Palabra("ala");
    Runnable pal3 = new Palabra("Oso");
    
    new Thread(pal1).start();
    new Thread(pal2).start();
    new Thread(pal3).start();
    System.out.println("Hilos terminados.");
  }
}
