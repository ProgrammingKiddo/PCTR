package ejer3;

import java.lang.InterruptedException;

class Usa_Hilo{

    public static void main(String[] args){

        Hilo hilo1, hilo2;
        int resultado;

        hilo1 = new Hilo(10000, 0);
        hilo2 = new Hilo(10000, 1);

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException ex){
            System.out.println(ex.toString());
        }

        resultado = Hilo.observar();
        System.out.println("El resultado de los hilos es " + resultado + ".");
    }
}