package P3.e1;

import java.util.Random;

class prodEscalarParalelo extends Thread
{

    int _idHebra;
    int _inicioVector;
    int _finalVector;

    private static int tamanho = 1000000;
    private static int[] vectorV = new int[tamanho];
    private static int[] vectorW = new int[tamanho];
    private static int[] productoParcial;
    private static prodEscalarParalelo[] hilos;
    private static int numHilos;

    public prodEscalarParalelo(int idHebra, int inicioVector, int finalVector)
    {
        _idHebra = idHebra;
        _inicioVector = inicioVector;
        _finalVector = finalVector;
    }

    public void run()
    {
        productoParcial[_idHebra] = 0;
        for (int i = _inicioVector; i < _finalVector; i++)
        {
            productoParcial[_idHebra] += vectorV[i] * vectorW[i];
        }
    }

    public static void main(String[] args)
    {
        int escalar = 0;

        if (args.length >= 1)
        {
            numHilos = Integer.parseInt(args[0]);
            if (numHilos >= 1)
            {
                crearVectores();
                distribuirTareas();
                ejecutarHebras();
                
                for (int i = 0; i < numHilos; i++)
                {
                    escalar = escalar + productoParcial[i];
                }
                System.out.println("El resultado paralelo del producto parcial es " + escalar + ".");
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
    
    
    private static void crearVectores()
    {
        for (int i = 0; i < tamanho; i++)
        {
            vectorV[i] = 1;
            vectorW[i] = 1;
        }
    }
    
    private static void distribuirTareas()
    {
        int dominio;
        int inicioDom;
        int finalDom;
        dominio = tamanho / numHilos;
        
        if (tamanho % numHilos != 0)
        {
            // Creamos un hilo adicional al que asignarle el trabajo sobrante
            numHilos++;
        }
        hilos = new prodEscalarParalelo[numHilos];
        productoParcial = new int[numHilos];


        for (int i = 0; i < numHilos; i++)
        {
            inicioDom = i * dominio;
            finalDom = inicioDom + dominio;

            // Si la ultima asignacion tiene un dominio de problema menor, ajustamos la posicion
            // final de acceso al final del vector
            if (finalDom > tamanho)
            {
                finalDom = tamanho;
            }
            hilos[i] = new prodEscalarParalelo(i, inicioDom, finalDom);
        }
    }

    private static void ejecutarHebras()
    {
        for (prodEscalarParalelo p : hilos)
        {
            p.start();
        }

        try{
            for(prodEscalarParalelo p : hilos)
            {
                p.join();
            }
        } catch (InterruptedException ex)
        {
            System.err.println(ex.toString());
        }
    }
}