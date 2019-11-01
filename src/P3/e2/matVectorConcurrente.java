package P3.e2;

import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class matVectorConcurrente implements Runnable
{
    private static int tamanho = 30000;
    private static int[][] matriz = new int[tamanho][tamanho];
    private static int[] vectorOrigen = new int[tamanho];
    private static int[] vectorProducto = new int[tamanho];
    private static int numHilos;

    private int _inicio;
    private int _dominio;

    public matVectorConcurrente(int inicio, int dominio)
    {
        _inicio = inicio;
        _dominio = dominio;
    }

    public static void main(String[] args)
    {
        if (args.length >= 1)
        {
            numHilos = Integer.parseInt(args[0]);
            if (numHilos >= 1)
            {
                rellenarVector();
                productoVectorial();
            }
            else
            {
                System.err.println("Introduzca al menos un hilo.");
            }
        }
        else
        {
            System.err.println("Introduzca el numero de hebras.\n\tSintaxis: java prodEscalarParalelo n");
        }
    }

    private static void rellenarVector()
    {
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++)
        {
            /*
            for (int j = 0; j < tamanho; j++)
            {
                matriz[i][j] = rand.nextInt(3);
            }
            */
            vectorOrigen[i] = rand.nextInt(3);
        }
    }

    private static void productoVectorial()
    {
        Thread[] hilos = new Thread[numHilos];
        int dominioProblema = tamanho / numHilos;
        boolean noDivisible = false;

        if (tamanho % numHilos != 0)
        {
            noDivisible = true;
        }
        
        // Creamos los hilos y les asignamos un dominio del problema
        for (int i = 0; i < numHilos; i++)
        {
            // Si el tamanho del problema no es divisible entre el numero de hilos
            if ((noDivisible) && (i == numHilos -1))
            {
                // Asignamos al ultimo hilo el restante de datos
                hilos[i] = new Thread(new matVectorConcurrente(i * dominioProblema, tamanho - (i * dominioProblema)));
            }
            else
            {
                hilos[i] = new Thread(new matVectorConcurrente(i * dominioProblema, dominioProblema));
            }
        }

        // Preparamos el cronometro para medir el tiempo
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
        long inicCronom = System.currentTimeMillis();
        System.out.println("Trabajo iniciado a las " + df.format(d) + ".");
        // Lanzamos los hilos
        for (Thread h : hilos)
        {
            h.start();
        }
        // Activamos el cronómetro
        d.setTime(inicCronom);

        // Esperamos a la ejecución de todos los hilos
        for (Thread h : hilos)
        {
            try{
                h.join();
            } catch(InterruptedException ex)
            {
                System.err.println(ex.toString());
            }
        }
        // Paramos el cronometro y obtenemos el resultado
        long finCronom = System.currentTimeMillis();
        d.setTime(finCronom);

        System.out.println("Trabajo terminado a las " + df.format(d) + ".");
        System.out.println("Tarea realizada en " + (finCronom - inicCronom) + " milisegundos.");
        //imprimirVectorResultado();
    }
    
    private static void imprimirVectorResultado()
    {
        for(int n : vectorProducto)
        {
            System.out.println(n);
        }
    }

    public void run()
    {
        int finalDominio = _inicio + _dominio;
        int suma;
        Random rand = new Random();

        for (int i = _inicio; i < finalDominio; i++)
        {
            suma = 0;
            for (int j = 0; j < tamanho; j++)
            {
                matriz[i][j] = rand.nextInt(3);
                suma = suma + (matriz[i][j] * vectorOrigen[j]);
            }
            vectorProducto[i] = suma;
        }
    }
}