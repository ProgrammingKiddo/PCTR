//Copyright (c) 2018, Borja Fern�ndez Merch�n

/**
 * @author Borja
 * @version 1.0
 * @since 2018-01-12
 */

package bonoloto;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.util.Random;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto{

    static int[] apuestaGanadora;

    sBonoLoto() throws RemoteException{

    }


    public static void main(String[] args){

        sBonoLoto servidor;

        servidor = null;
        apuestaGanadora = new int[6];

        try{
            servidor = new sBonoLoto();
        } catch(RemoteException ex){
            System.err.println(ex.toString());
        }

        try{
            Naming.rebind("//" + args[0] + "/Servidor", servidor);
        } catch(RemoteException ex){
            System.err.println(ex.toString());
        } catch(MalformedURLException ex){
            System.err.println(ex.toString());
        }

        System.out.println("Servidor listo.");
        
    }

    @Override
    public void resetServidor() throws RemoteException{
        
        Random rand;
        int i;

        rand = new Random();

        for(i = 0; i < 6; i++){
            apuestaGanadora[i] = rand.nextInt(49) + 1;  //Sumamos uno porque el rango de valores es [0,49)
        }
    }

    @Override
    public boolean compApuesta(int[] apuesta) throws RemoteException{

        int i;
        boolean acierto;

        i = 0;
        acierto = true;

        while(i < 6 && acierto == true){
            if(apuesta[i] != apuestaGanadora[i]){
                acierto = false;
            }
        }

        return acierto;
    }
}