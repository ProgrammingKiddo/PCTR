  /**
   * Clase Linea.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  public class Linea {
    private boolean linea_ocupada;

    public Linea() {
      linea_ocupada = false;
    }

    public synchronized void CambiarEstado() {
      if(linea_ocupada)
        linea_ocupada = false;
      else
        linea_ocupada = true;
    }

    public synchronized boolean LineaOcupada() {
      return linea_ocupada;
    }
  }
