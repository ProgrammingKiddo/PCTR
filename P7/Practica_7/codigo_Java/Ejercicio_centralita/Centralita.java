  /**
   * Programa que simula el comportamiento de una centralita con varios teléfonos.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Centralita {

    //Programa principal
    public static void main (String[] args) {
      Linea linea = new Linea();

      Thread tel1 = new Thread(new Telefono(1, linea));
      Thread tel2 = new Thread(new Telefono(2, linea));
      Thread tel3 = new Thread(new Telefono(3, linea));
     
      tel1.start();
      tel2.start();
      tel3.start();
    }

  }
