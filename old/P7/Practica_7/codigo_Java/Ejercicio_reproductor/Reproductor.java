  /**
   * Clase Reproductor.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Reproductor {

    //Atributos privados
    private int id_track;
    private boolean pause = false;
    private boolean playing = false;
    private static final int MAX_TRACK = 22;

    //Constructor
    public Reproductor() {}
    public Reproductor(int pista) {
      id_track = pista;
    }

    //Métodos
    public synchronized void Reproducir() {
      if (!playing) {
        if (id_track == 0) {
          id_track = 1;
          System.out.println("Reproduciendo pista " + id_track + ".");
        }
        else if (id_track < 0 || id_track > MAX_TRACK) {
          id_track = 1;
          System.out.println("Pista no encontrada. Reproduciendo desde el principio: pista " + id_track);
        }
        pause = false;
        playing = true;
      }
    }

    public synchronized void Reproducir(int pista) {
      if (pista > 0 && pista <= MAX_TRACK) {
        id_track = pista;
        System.out.println("Reproduciendo pista seleccionada. Reproduciendo pista " + id_track + ".");
        pause = false;
        playing = true;
      }
    }

    public synchronized void Pausar() {
      if(playing == true) {
        if (pause == false) {
          pause = true;
          System.out.println("Reproducción en pausa: pista " + id_track);
        }
        else {
          pause = false;
          System.out.println("Reanudando reproducción: pista " + id_track);
        }
      }
    }

    public synchronized void Parar() {
      if(playing == true) {
        pause = false;
        playing = false;
        System.out.println("Reproducción parada.");
      }
      id_track = 0;
    }

    public synchronized void Anterior() {
      if(id_track == 0) {
        id_track = MAX_TRACK;
      }
      else
        --id_track;
      System.out.println("Cambio a la pista anterior. Pista actual: " + id_track);
    }

    public synchronized void Siguiente() {
      if(id_track == MAX_TRACK) {
        id_track = 0;
      }
      else
        ++id_track;
      System.out.println("Cambio a la siguiente pista. Pista actual: " + id_track);
    }

  }
