package P2.e2;


class Usa_tareaRunnable
{
    public static void main(String[] args)
    {
        int resultado;

        Thread hilo1 = new Thread(new tareaRunnable(10000, 0));
        Thread hilo2 = new Thread(new tareaRunnable(10000, 1));

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException ex){
            System.out.println(ex.toString());
        }

        resultado = tareaRunnable.observar();
        System.out.println("El resultado de la ejecución de las tareas es " + resultado + ".");
    }
}