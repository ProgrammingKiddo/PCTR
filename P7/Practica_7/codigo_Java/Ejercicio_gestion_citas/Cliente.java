  /**
   * Clase Cliente.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Cliente extends Thread {

    //Atributo privado
    private int cita;
    private static Citas citas;

    //Constructor de la clase
    public Cliente() {}
    public Cliente(Citas cit) {
      citas = cit;
    }

    //Método modificador
    public void pedirCita() {
      synchronized(citas) {
        if(citas.citasDisponibles() > 0) {
          cita = citas.asignarCita();
          System.out.println("La cita asignada es la número " + cita + ".");
        }
        else
          System.out.println("Mejor, para otro día.");
          this.stop();
      }
    }

    //Código que ejecuta cada cliente
    public void run() {
      while(cita == 0) {
        this.pedirCita();
      }
      
    }

    //Programa principal
    public static void main (String[] args) {
      citas = new Citas(5);

      Cliente [] clientes = new Cliente[6];
      for(int i = 0; i < 6; ++i) {
        clientes[i] = new Cliente(citas);
        clientes[i].start();
      }
    }

}
