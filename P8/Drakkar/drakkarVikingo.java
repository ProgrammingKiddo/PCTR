import java.util.concurrent.locks.Lock;
import java.util.Scanner;
import java.lang.Thread;

public class drakkarVikingo implements Runnable{

    private static int marmita = 10;
    private int id;
    private static final Object lock = new Object();

    drakkarVikingo[] vikingos = new drakkarVikingo[8];


    public drakkarVikingo(int id){
        this.id = id;
    }


    public void run(){
        synchronized(lock){
            vikingos();
        }
    }

    public synchronized void vikingos(){

        if(marmita == 0){

            System.out.println("La marmita está vacía, ¡el cocinero debe apresurarse!");

            while(marmita == 0){
                try{
                    cocinero();
                    lock.wait();
                } catch(InterruptedException ex){
                    System.err.println(ex.toString());
                }
            }
        }

        comer();
        lock.notifyAll();
        System.out.println("A la marmita le quedan " + marmita + " raciones de angilas.");
    }

    //Productor
    private synchronized void cocinero(){

        while(marmita != 0){
            try{
                lock.wait();
            } catch(InterruptedException ex){
                System.err.println(ex.toString());
            }
        }

        System.out.println("El cocinero está rellenando la marmita.");
        marmita = 10;
        System.out.println("La marmita está llena de nuevo, listo para que se alimente otro aguerrido vikingo.");
        lock.notifyAll();
    }

    //Consumidor
    private synchronized void comer(){

        marmita--;
        System.out.println("El vikingo " + (id+1) + " ha comido unas deliciosas angilas al eneldo.");
    }


    public static void main(String[] args){

        Thread[] vikingos;
        int n_vikingos, i;

        n_vikingos = getNumeroVikingos();
        vikingos = new Thread[n_vikingos];

        for(i = 0; i < n_vikingos; i++){
            vikingos[i] = new Thread(new drakkarVikingo(i));
            vikingos[i].start();
        }

        for(i = 0; i < n_vikingos; i++){
            try{
                vikingos[i].join();
            } catch(InterruptedException ex){
                System.err.println(ex.toString());
            }
        }
        
    }
    
    private static int getNumeroVikingos(){
        
        Scanner teclado;
        int n_vikingos;
        
        teclado = new Scanner(System.in);
        System.out.println("¿Cuántos vikingos hay a la mesa?");
        if(teclado.hasNextInt()){
            n_vikingos = teclado.nextInt();
        } else{
            System.out.println("Como no has introducido un número, los vikingos se han hecho un lío"+
                                "y sólo se han sentado ocho a la mesa.");
            n_vikingos = 8;
        }
        
        teclado.close();
        return n_vikingos;
    }
    
}