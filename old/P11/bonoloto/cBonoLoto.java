//Copyright (c) 2018, Borja Fern�ndez Merch�n

/**
 * @author Borja Fern�ndez Merch�n
 * @version 1.0
 * @since 2018-01-12
 */

package bonoloto;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.Scanner;


public class cBonoLoto extends UnicastRemoteObject{

    static Scanner teclado;
    static iBonoLoto servidor;

    cBonoLoto() throws RemoteException{

    }

    public static void main(String[] args){

        int[] apuesta;
        String texto;

        servidor = null;

        try{
            servidor = (iBonoLoto) Naming.lookup("//" + args[0] + "/Servidor");
        } catch(NotBoundException ex){
            System.err.println(ex.toString());
        } catch(RemoteException ex){
            System.err.println(ex.toString());
        } catch(MalformedURLException ex){
            System.err.println(ex.toString());
        }
        
        if(!servidor.equals(null)){

            teclado = new Scanner(System.in);
            apuesta = new int[6];

            do{
                try{
                    servidor.resetServidor();
                } catch(RemoteException ex){
                    System.err.println(ex.toString());
                }
                apuesta = pedirApuesta();
                comprobarAcierto(apuesta);
                System.out.println("Si desea dejar de jugar, escriba \"salir\".");
                texto = teclado.nextLine();
            } while(texto.equalsIgnoreCase("salir"));

            teclado.close();
        }
    }

    private static int[] pedirApuesta(){
        
        int[] apuesta;
        int i;

        i = 0;
        apuesta = new int[6];

        System.out.println("Por favor, introduzca seis números entre el 1 y el 49 para su apuesta: ");
        
        do{
            if(teclado.hasNextInt()){
                apuesta[i] = teclado.nextInt();
                if(apuesta[i] < 1 || apuesta[i] > 49){
                    System.out.println("Por favor, introduce un numero valido.");
                } else{
                    i++;    //Número admitido, pasamos al siguiente.
                }
            } else{
                System.out.println("Por favor, introduce un entero.");
            }
        } while(i < 6);

        return apuesta;
    }

    private static void comprobarAcierto(int[] apuesta){

        boolean acierto;

        acierto = false;

        try{
            acierto = servidor.compApuesta(apuesta);
        } catch(RemoteException ex){
            System.err.println(ex.toString());
        }

        if(acierto){
            System.out.println("Ganaste! Has acertado de pleno.");
        } else{
            System.out.println("Mas suerte la proxima vez.");
        }
    }
}