package P2.e5;

class tareaRunnableLamda implements Runnable
{

    public static int valor = 0;
    private int _nIteraciones;
    private MathOperation _op;

    public static MathOperation adicion = (int a, int b) -> a + b;
    public static MathOperation substraccion = (int a, int b) -> a - b;


    public tareaRunnableLamda(MathOperation op, int nIteraciones)
    {
        _op = op;
        _nIteraciones = nIteraciones;
    }


    public static void main(String[] args)
    {
        Thread hilo1 = new Thread(new tareaRunnableLamda(adicion, 10000));
        Thread hilo2 = new Thread(new tareaRunnableLamda(substraccion, 10000));

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException ex){
            System.out.println(ex.toString());
        }

        System.out.println("El resultado de las tareas con expresiones lambda es " + valor + ".");
    }

    public void run()
    {
        for (int i = 0; i < _nIteraciones; i++)
        {
            valor = this.operate(valor, 1, _op);
        }
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}