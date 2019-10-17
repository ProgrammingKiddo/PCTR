  /**
   * Programa en Java que crea y lanza varios hilos utilizando la clase Mult10.
   *
   * @author Natalia Partera
   * @version 1.0
   */

  public class UsaMult10 {
    public static void main (String[] args) throws InterruptedException {
      Runnable m1 = new Mult10(12);
      Runnable m2 = new Mult10(5);
      Runnable m3 = new Mult10(28);
      //Creamos los hilos
      Thread hilo1 = new Thread(m1);
      Thread hilo2 = new Thread(m2);
      //A continuación lanzamos los hilos
      hilo1.start();
      hilo2.start();
      //O creamos y lanzamos el hilo en una sola instrucción
      new Thread(m3).start();
      //Esperamos a que terminen los hilos
      hilo1.join();
      hilo2.join();
      System.out.println("Hilos terminados.");
    }
  }
