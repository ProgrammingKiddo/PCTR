package paralelo;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;
import java.lang.InterruptedException;

public class escalaVectorParalelo implements Runnable{

	static int[] v;
	int iteraciones, inicio, escalar, id;


	public escalaVectorParalelo(int iteraciones, int inicio, int escalar, int id){

		this.iteraciones = iteraciones;
		this.inicio = inicio;
		this.escalar = escalar;
		this.id = id;
	}

	public void run(){

		int i;

		for(i = inicio; i < iteraciones; i++){
			v[i] = v[i] * escalar;
		}

		System.out.println("\nHilo " + id + " listo!");
	}


	public static void main(String[] args){

		Scanner teclado;
		Thread hilo1, hilo2, hilo3, hilo4, hilo5;
		int escalarLocal, i, vectorSize;

		teclado = new Scanner(System.in);
		vectorSize = 10000;
		v = new int[vectorSize];
		
		inicializarVector();
		imprimirVector();

		
		System.out.println("Introduce el escalar: ");
		escalarLocal = teclado.nextInt();

		hilo1 = new Thread(new escalaVectorParalelo(vectorSize/5, 0, escalarLocal, 1));
		hilo2 = new Thread(new escalaVectorParalelo(vectorSize/5, 2000, escalarLocal, 2));
		hilo3 = new Thread(new escalaVectorParalelo(vectorSize/5, 4000, escalarLocal, 3));
		hilo4 = new Thread(new escalaVectorParalelo(vectorSize/5, 6000, escalarLocal, 4));
		hilo5 = new Thread(new escalaVectorParalelo(vectorSize/5, 8000, escalarLocal, 5));


		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();

		try{
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
		} catch(InterruptedException ex){
			System.err.println(ex.toString());
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