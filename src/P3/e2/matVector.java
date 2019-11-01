package P3.e2;

import java.util.Random;

class matVector
{

    private static int tamanho = 10000;
    private static int[][] matriz = new int[tamanho][tamanho];
    private static int[] vectorOrigen = new int[tamanho];
    private static int[] vectorProducto = new int[tamanho];

    public static void main(String[] args)
    {
        int suma;
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++)
        {
            for (int j = 0; j < tamanho; j++)
            {
                matriz[i][j] = rand.nextInt(3);
            }
            vectorOrigen[i] = rand.nextInt(3);
        }

        for (int i = 0; i < tamanho; i++)
        {
            suma = 0;
            for (int j = 0; j < tamanho; j++)
            {
                suma = suma + (matriz[i][j] * vectorOrigen[j]);
            }
            vectorProducto[i] = suma;
            System.out.println(suma);
        }
        
    }
}