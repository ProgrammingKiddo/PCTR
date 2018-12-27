  /**
   * Clase CuentaAtras.
   * [Ejemplo]
   * @author Natalia Partera
   * @version 1.0
   */

  public class CuentaAtras {

    //Atributo privado
    private int cont;

    //Constructor de la clase
    public CuentaAtras(int num) {
      if(num > 0)
        cont = num;
      else
        cont = 0;
    }

    //Método modificador que decrementa la variable
    public void contar() {
      System.out.println("Actualizando...");
      synchronized(this) {
        if(cont > 0) {
          System.out.println("Contador actualizado: " + cont);
          --cont;
        }
      }
      System.out.println("Variable actualizada.");
    }

    //Método observador que devuelve el valor de la variable
    public int valor() {
      synchronized(this) {
        return cont;
      }
    }

  }
