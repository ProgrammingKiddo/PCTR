  /**
   * Código de ejemplo para ilustrar el uso de TimerTask.
   * 
   * @author Natalia Partera
   * @version 1.0
   */

  import java.util.*;

  public class MiTimerTask extends TimerTask {
    private int num;

    MiTimerTask() {
      num = 0;
    }

    MiTimerTask(int n) {
      num = n;
    }

    public void run() {
      for(int i = 0; i < 10; ++i) {
        System.out.println(num);
        ++num;
      }
    }

  }
