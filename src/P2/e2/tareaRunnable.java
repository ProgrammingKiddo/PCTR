package P2.e2;

class tareaRunnable implements Runnable
{
    private static int n;
    private int tipoTarea, nVueltas;

    public tareaRunnable(int nVueltas, int tipoTarea)
    {
        this.nVueltas = nVueltas;
        this.tipoTarea = tipoTarea;
    }

    public void run()
    {
        int i;

        for (i = 0; i < nVueltas; i++)
        {
            if (tipoTarea == 0)
            {
                n++;
            }
            else
            {
                n--;
            }
        }
    }

    public static int observar()
    {
        return n;
    }
}