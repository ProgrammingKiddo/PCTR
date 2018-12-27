  /**
   * Clase Citas.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Citas {

    //Atributos privados
    private int asignadas;
    private int numCitas = 10;

    //Constructor de la clase
    public Citas() {}
    public Citas(int num) {
      numCitas = num;
    }

    //Método modificador que asigna una cita al cliente que lo invoca
    public int asignarCita() {
      synchronized(this) {
        int num;
        if(numCitas > asignadas) {
          ++asignadas;
          num = asignadas;
        }
        else {
          System.out.println("Lo sentimos, no quedan citas.");
          num = -1;
        }
        return num;
      }
    }

    //Método observador que indica si hay citas disponibles
    public int citasDisponibles() {
      return (numCitas - asignadas);
    }

    //Método observador que muestra las citas disponibles
    public void verCitasDisponibles() {
      System.out.println("Quedan " + (numCitas - asignadas) + " citas libres para hoy.");
    }
  }
