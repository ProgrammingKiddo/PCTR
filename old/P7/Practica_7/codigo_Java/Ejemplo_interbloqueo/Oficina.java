  /**
   * Programa que
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class Oficina {

    //Programa principal
    public static void main (String[] args) {
      final Objeto reglas = new Objeto("Reglas");
      final Objeto boli = new Objeto("Boligrafo");
      
//      Trabajador1 t1 = new Trabajador1(reglas, boli);
//      Trabajador2 t2 = new Trabajador2(reglas, boli);
      Trabajador t1 = new Trabajador("Pepe", reglas, boli);
      Trabajador t2 = new Trabajador("Juan", boli, reglas);

      t1.start();
      t2.start();
    }

  }
