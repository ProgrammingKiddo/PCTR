package P2.e1;

import java.lang.Thread;

class hebra extends Thread{

  private static int n;
  private int tipoHilo, nVueltas;

  public hebra(int nVueltas, int tipoHilo){
    this.nVueltas = nVueltas;
    this.tipoHilo = tipoHilo;
  }

  public void run(){

    int i;

    for(i = 0; i < nVueltas; i++){
      if(tipoHilo == 0){
        n++;
      } else{
        n--;
      }
    }

  }

  public static int observar(){
    return n;
  }

}