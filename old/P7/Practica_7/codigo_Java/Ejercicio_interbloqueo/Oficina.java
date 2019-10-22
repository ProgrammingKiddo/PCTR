  /**
   * Programa que representa el funcionamiento de una oficina con materiales 
   * compartidos.
   * [Ejercicio]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Oficina {

    //Programa principal
    public static void main (String[] args) {
      final Objeto reglas = new Objeto("Reglas");
      final Objeto boli = new Objeto("Boligrafo");
      
      Trabajador t1 = new Trabajador("Pepe", reglas, boli);
      Trabajador t2 = new Trabajador("Juan", reglas, boli);

      t1.start();
      t2.start();
    }

  }
