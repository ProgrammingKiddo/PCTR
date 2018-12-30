/*Ejemplo de servidor de sockets multihilo
 *@Antonio Tomeu
 *@version 1.0
*/


import java.net.*;
import java.io.*;

public class Servidor_Hilos extends Thread
{
    Socket enchufe;
    public Servidor_Hilos(Socket s)
    {enchufe = s; this.start();}

    public void run()
    {
        try{
            int j;
            int i = Integer.valueOf(datos).intValue();

            String datos = entrada.readLine();
            BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));

            for(j = 1; j <= 20; j++){
                System.out.println("El hilo " + this.getName() + " está escribiendo el dato " + i);
                sleep(1000);
            }
            enchufe.close();
            System.out.println("El hilo " + this.getName() + "cierra su conexion...");
        } catch(Exception e) {
            System.out.println("Error...");
        }
    }//run

    public static void main (String[] args)
    {
        int i;
        int puerto = 2001;

        try{
            ServerSocket chuff = new ServerSocket (puerto, 4000);

            while (true){     
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                new Servidor_Hilos(cable);
            }//while
        } catch (Exception e) {
            System.out.println("Error en sockets...");
        }
    }//main

}//Servidor_Hilos
