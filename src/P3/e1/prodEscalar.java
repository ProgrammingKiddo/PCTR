package P3.e1;

import java.util.Random;

class prodEscalar
{

    public static void main(String[] args)
    {
        int escalar;
        Random rand = new Random();
        int[] vectorV = new int[1000000];
        int[] vectorW = new int[1000000];

        for (int i = 0; i < 1000000; i++)
        {
            vectorV[i] = rand.nextInt(10);
            vectorW[i] = rand.nextInt(10);
        }

        escalar = escalarVectores(vectorV, vectorW);

        System.out.println("El resultado de escalar los vectores es " + escalar + ".");
    }


    private static int escalarVectores(int[] vectorV, int[] vectorW)
    {
        int escalar = 0;

        for (int i = 0; i < vectorV.length; i++)
        {
            escalar = escalar + (vectorV[i] * vectorW[i]);
        }
        return escalar;
    }
}