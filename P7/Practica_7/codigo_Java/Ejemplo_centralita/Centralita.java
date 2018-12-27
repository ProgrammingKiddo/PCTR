  /**
   * Programa que simula el comportamiento de una centralita con varios teléfonos.
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Centralita {

    //Programa principal
    public static void main (String[] args) {
      Thread tel1 = new Thread(new Telefono(1));
      Thread tel2 = new Thread(new Telefono(2));
      Thread tel3 = new Thread(new Telefono(3));
     
      tel1.start();
      tel2.start();
      tel3.start();
    }

  }
