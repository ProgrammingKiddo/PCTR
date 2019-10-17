/**
 * Programa en Java que crea y lanza varios hilos utilizando la clase Cuenta50.
 *
 * @author Natalia Partera
 * @version 1.0
 */


public class UsaCuenta50 {
  public static void main (String[] args) throws InterruptedException {
    Cuenta50 c1 = new Cuenta50(0);
    Runnable c2 = new Cuenta50(63);
    Runnable c3 = new Cuenta50(102);
    //Creamos los hilos
    Thread hilo1 = new Thread(c1);
    Thread hilo2 = new Thread(c2);
    //A continuación lanzamos los hilos
    hilo1.start();
    hilo2.start();
    new Thread(c3).start();
    //Esperamos a que terminen los hilos
    hilo1.join();
    hilo2.join();
    System.out.println("Hilos terminados.");
  }
}
