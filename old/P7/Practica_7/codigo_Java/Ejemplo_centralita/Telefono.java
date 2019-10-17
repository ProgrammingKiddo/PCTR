  /**
   * Clase Telefono.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Telefono implements Runnable{

    //Atributos privados
    private int id;

    //Constructor
    public Telefono() {}
    public Telefono(int id) {
      this.id = id;
    }

    //Métodos
    public synchronized void LlamadaEntrante() {
      System.out.println("Teléfono " + id + ": Iniciando llamada entrante.");
      for(int i = 0; i < 500; ++i) {}
      System.out.println("Teléfono " + id + ": Llamada entrante en curso.");
      for(int i = 501; i < 1000; ++i) {}
      System.out.println("Teléfono " + id + ": Finalizando llamada entrante.");
    }

    public synchronized void LlamadaSaliente() {
      System.out.println("Teléfono " + id + ": Iniciando llamada saliente.");
      for(int i = 0; i < 500; ++i) {}
      System.out.println("Teléfono " + id + ": Llamada saliente en curso.");
      for(int i = 501; i < 1000; ++i) {}
      System.out.println("Teléfono " + id + ": Finalizando llamada saliente.");
    }

    //Método run()
    public void run() {
      for(int i = 0; i < 5; ++i) {
        LlamadaEntrante();
        LlamadaSaliente();
      }
    }

  }
