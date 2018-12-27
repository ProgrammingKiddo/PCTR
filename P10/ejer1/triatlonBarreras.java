/**
 * @author Borja Fern�ndez Merch�n
 * @version 1.0
 * @since 15/01/2018
 */

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.lang.InterruptedException;

public class triatlonBarreras implements Runnable{

    static int[] tiempos;
    static final CyclicBarrier barrera = new CyclicBarrier(100);
    //Atributos de cada objeto, para identificarlo y para poder crear números aleatorios de manera eficaz, respectivamente
    int id;
    Random rand;

    triatlonBarreras(int id){
        this.id = id;
        rand = new Random();
    }

    @Override
    public void run(){

        int timeToSleep, i;
        long inicioPosta, finalPosta;

        i = 0;

        while(i < 3){
            timeToSleep = rand.nextInt(1000);

            inicioPosta = System.currentTimeMillis();
            try{
                //Deberíamos coger también la excepción 'IllegarArgumentException', pero sabemos que el valor
                //  'timeToSleep' va a estar comprendido en el rango [0,100) siempre.
                Thread.sleep(timeToSleep);
            } catch(InterruptedException ex){
                System.err.println(ex.toString());
            }
            finalPosta = System.currentTimeMillis();
            
            tiempos[id] += finalPosta - inicioPosta;

            try{
                barrera.await();
            } catch(InterruptedException ex){
                System.err.println(ex.toString());
            } catch(BrokenBarrierException ex){
                System.err.println(ex.toString());
            }
            i++;
        }
    }


    public static void main(String[] args){

        Thread atletas[];
        int menorTiempo, atletaGanador, i;

        //barrera = new CyclicBarrier(100);
        atletas = new Thread[100];

        inicializarTiempos();

        for(i = 0; i < atletas.length; i++){
            atletas[i] = new Thread(new triatlonBarreras(i));
            atletas[i].start();
        }

        for(i = 0; i < atletas.length; i++){
            try{
                atletas[i].join();
            } catch(InterruptedException ex){
                System.err.println(ex.toString());
            }
        }

        menorTiempo = tiempos[0];
        atletaGanador = 0;

        for(i = 1; i < atletas.length; i++){
            if(tiempos[i] < menorTiempo){
                menorTiempo = tiempos[i];
                atletaGanador = i;
            }
        }

        System.out.println("El ganador del triatlon es el atleta " + atletaGanador + ", con un tiempo de " + menorTiempo + " milisegundos!");

    }

    public static void inicializarTiempos(){

        int i;
        
        tiempos = new int[100];

        for(i = 0; i < tiempos.length; i++){
            tiempos[i] = 0;
        }
    }
}