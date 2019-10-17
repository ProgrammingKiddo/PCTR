  /**
   * Clase Contador.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Contador {

    //Atributos privados
    private int num = 0;

    //Constructor
    public Contador() {}

    //Métodos
    public synchronized void aumentar() {
      ++num;
    }

    public synchronized void aumentar(int cant) {
      num = num + cant;
    }

    public synchronized int ver() {
      return num;
    }

  }
