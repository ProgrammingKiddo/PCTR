package ejer3;

import java.lang.Thread;

class Hilo extends Thread{

  private static int n;
  private int tipoHilo, nVueltas;

  public Hilo(int nVueltas, int tipoHilo){
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