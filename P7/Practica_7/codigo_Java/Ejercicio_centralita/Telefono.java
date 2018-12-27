  /**
   * Clase Telefono.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Telefono implements Runnable{

    //Atributos privados
    private int id;
    private Linea linea;

    //Constructor
    public Telefono() {}
    public Telefono(int id, Linea lin) {
      this.id = id;
      linea = lin;
    }

    //Métodos
    public synchronized void LlamadaEntrante() {
      System.out.println("Teléfono " + id + ": Iniciando llamada entrante.");
      for(int i = 0; i < 500; ++i) {}
      System.out.println("Teléfono " + id + ": Llamada entrante en curso.");
      for(int i = 501; i < 1000; ++i) {}
      System.out.println("Teléfono " + id + ": Finalizando llamada entrante.");
      linea.CambiarEstado();
      notify();
    }

    public synchronized void LlamadaSaliente() {
      System.out.println("Teléfono " + id + ": Iniciando llamada saliente.");
      for(int i = 0; i < 500; ++i) {}
      System.out.println("Teléfono " + id + ": Llamada saliente en curso.");
      for(int i = 501; i < 1000; ++i) {}
      System.out.println("Teléfono " + id + ": Finalizando llamada saliente.");
      linea.CambiarEstado();
      notify();
    }

    //Método run()
    public void run() {
      for(int i = 0; i < 15; ++i) {
        synchronized(linea) {
          while(linea.LineaOcupada()) {
            try {
              wait();
            } catch(Exception e) {}
          }
          linea.CambiarEstado();
          if(i%2 == 0) {
            LlamadaEntrante();
          }
          else {
            LlamadaSaliente();
          }
        }
      }
    }

  }
