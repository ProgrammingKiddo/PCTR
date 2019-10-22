  /**
   * Programa que realiza una cuenta atrás usando varios hilos.
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class UsaCuentaAtras extends Thread {

    //Variable compartida que debe ser ejecutada en EM.
    private static CuentaAtras cont;

    //Código que ejecuta cada hilo
    public void run() {
      while(cont.valor() > 0) {
        cont.contar();
      }
    }

    //Programa principal
    public static void main (String[] args) {
      cont = new CuentaAtras(50);
      UsaCuentaAtras hilo1 = new UsaCuentaAtras();
      UsaCuentaAtras hilo2 = new UsaCuentaAtras();
      UsaCuentaAtras hilo3 = new UsaCuentaAtras();

      hilo1.start();
      hilo2.start();
      hilo3.start();
    }

  }
