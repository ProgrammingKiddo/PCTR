import java.util.Scanner;
import java.util.Random;


class escalaVector{

	static int[] v;

	public static void main(String[] args){

		Scanner teclado;
		Random rand;
		int i, escalar;

		teclado = new Scanner(System.in);
		rand = new Random();
		v = new int[1000];

		inicializarVector();
		imprimirVector();

		System.out.println("Introduce el escalar: ");
		escalar = teclado.nextInt();

		for(i = 0; i < v.length; i++){
			v[i] = v[i] * escalar;
		}

		imprimirVector();
		teclado.close();
	}


	private static void inicializarVector(){

		Random rand;
		int i;

		rand = new Random();

		for(i = 0; i < v.length; i++){
			//Para evitar saturar mucho al ordenador con cálculos innecesarios, establecemos
			//unos valores iniciales del vector pequeños.
			v[i] = rand.nextInt(10);
		}
	}

	private static void imprimirVector(){

		int i;

		for(i = 0; i < v.length; i++){
			System.out.print(v[i]);
		}
		System.out.println("");

	}

}