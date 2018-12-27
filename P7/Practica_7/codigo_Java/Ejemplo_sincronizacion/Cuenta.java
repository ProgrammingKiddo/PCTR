  /**
   * Clase Cuenta.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Cuenta extends Thread {

    //Atributos privados
    private static Contador cont;
    private int num_min;
    private int num_max;
    private int constante;

    //Constructor
    public Cuenta() {}
    public Cuenta(Contador c, int min, int max, int cte) {
      cont = c;
      num_min = min;
      num_max = max;
      constante = cte;
    }

    //Métodos
    public void run() {
      synchronized(cont) {
        while(cont.ver() < num_max) {
          while(cont.ver() < num_min || cont.ver() > num_max) {
            try {
              wait();
            } catch (Exception e) {}
          }
          cont.aumentar(constante);
          System.out.print(cont.ver() + " ");
          cambiarHilo();
        }
      }
    }

    public synchronized void cambiarHilo() {
      if(cont.ver() >= num_max) {
        notifyAll();
        this.stop();
      }
    }

    public static void main (String[] args) throws InterruptedException
    {
      Contador cont = new Contador();

      Cuenta hilo1 = new Cuenta(cont, 0, 50, 1);
      Cuenta hilo2 = new Cuenta(cont, 50, 150, 5);
      
      hilo1.start();
      hilo2.start();
     
      hilo1.join();
      hilo2.join();
      System.out.println();
    }

  }
