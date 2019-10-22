package P2.e1;

import java.lang.InterruptedException;

class Usa_hebra{

    public static void main(String[] args){

        hebra hilo1, hilo2;
        int resultado;

        hilo1 = new hebra(10000, 0);
        hilo2 = new hebra(10000, 1);

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException ex){
            System.out.println(ex.toString());
        }

        resultado = hebra.observar();
        System.out.println("El resultado de los hilos es " + resultado + ".");
    }
}