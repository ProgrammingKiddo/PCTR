  /**
   * Programa que simula el manejo de un reproductor de música.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class UsaReproductor implements Runnable {

    //Objeto compartido
    static Reproductor rep;
    int button;
    static int num_oper = 0;

    //Constructor
    UsaReproductor(Reproductor ref, int boton) {
      rep = ref;
      button = boton;
    }

    //Método run
    public void run() {
      try {
        while(num_oper < 10) {
          switch(button) {
            case 1:
              if(num_oper%2 == 0)
                rep.Reproducir();
              else
                rep.Reproducir(num_oper);
              break;
            case 2:
              Thread.sleep(4500);
              rep.Pausar();
              break;
            case 3:
              Thread.sleep(10000);
              rep.Parar();
              break;
            case 4:
              Thread.sleep(6000);
              rep.Anterior();
              break;
            case 5:
              Thread.sleep(2000);
              rep.Siguiente();
              break;
          }
          ++num_oper;
          Thread.sleep(2500);
        }
      } catch(InterruptedException ie) {
          ie.printStackTrace();
          System.exit(-1);
      }
    }

    //Programa principal
    public static void main (String[] args) {
      Reproductor reproductor = new Reproductor();

      //Botón reproducir
      Thread bot1 = new Thread(new UsaReproductor(reproductor, 1));
      //Botón pausar
      Thread bot2 = new Thread(new UsaReproductor(reproductor, 2));
      //Botón parar
      Thread bot3 = new Thread(new UsaReproductor(reproductor, 3));
      //Botón anterior
      Thread bot4 = new Thread(new UsaReproductor(reproductor, 4));
      //Botón siguiente
      Thread bot5 = new Thread(new UsaReproductor(reproductor, 5));

      bot1.start();
      bot2.start();
      bot3.start();
      bot4.start();
      bot5.start();
    }
  }
