/*
 *@(#) piParalelo.java
 *@author A.T.
 *@version 1.0
*/

import java.util.Random;

public class piMonteCarloParalelo extends Thread{

  private float cx, cy;
  private static int intentos = 0;
  private static Object lock = new Object();  //Control de exclusión mutua.
  private int vueltas;
  private Random myRandom = new Random();
  
  public piMonteCarloParalelo(int n){
    
    vueltas = n;
  }
  
  public void run(){
    
    for(int i=0; i<vueltas; i++){

      cx = myRandom.nextFloat();  //Creación de las coordenadas X e Y
      cy = myRandom.nextFloat();  //de puntos aleatorios en el plano.

      if(Math.pow(cx, 2) + Math.pow(cy, 2) <=1 ){ //Si el punto está dentro de la circunferencia de radio 1.
        synchronized(lock){
          intentos++;   //Acierto!
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception{

    int nVueltas = 100000000;
    int nThreads = 1;
    long inicTiempo = System.nanoTime();

    piMonteCarloParalelo[] h = new piMonteCarloParalelo[nThreads];
    for(int i=0; i<nThreads; i++){
      h[i] = new piMonteCarloParalelo((int)(nVueltas/nThreads));  //Le asigna a cada hilo un número de iteraciones inversamente
                                                                  //proporcional al número de hebras.
    }

    for(int i=0; i<nThreads; i++){
      h[i].start();
    }
    for(int i=0; i<nThreads; i++){
      h[i].join();
    }
    long tiempoTotal = (System.nanoTime()-inicTiempo)/(long)1.0e9;

    System.out.println("Aproximacion: "+4.0*intentos/nVueltas);
    System.out.println("Valor Real: "+Math.PI);
    System.out.println("en "+tiempoTotal+" segundos...");
  }
}
