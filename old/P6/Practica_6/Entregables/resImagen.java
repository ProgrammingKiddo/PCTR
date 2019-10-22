/*
 * @author: Borja
 * @version: 1.0
 */

import java.util.*;


class resImagen
{

	static int imagen[][], imagenResaltada[][];
	static Random rand;

	public static void main(String[] args)
	{

		Scanner teclado;
		double timeStart, timeEnd;
		int size;

		teclado = new Scanner(System.in);	//Recordar que la clase Scanner no es "thread-safe"
		rand = new Random();

		System.out.print("Introduzca el tamaño de la imagen: ");
		size = teclado.nextInt();
		imagen = new int[size][size];
		imagenResaltada = new int[size][size];

		inicializarImagen();
		mostrarImagen(imagen);

		timeStart = System.currentTimeMillis();	//"Empezamos" el cronómetro guardando el tiempo actual
		resaltarImagen();		//El grueso del programa, donde está "la chicha".
		timeEnd = System.currentTimeMillis();	//"Paramos" el cronómetro guardando el tiempo actual

		mostrarImagen(imagenResaltada);

		System.out.println("El programa ha tardado " + (timeEnd - timeStart) + " milisegundos en resaltar la imagen."
							+ "\nRecuerde que el tiempo que tarde en mostrar la imagen nos es indiferente (no es tiempo de cálculo).");
		

	}

	private static void resaltarImagen(){

		int i, j, aux;

		for(i = 0; i < imagen.length; i++){
			for(j = 0; j < imagen[i].length; j++){

				aux = 4*getElementoImagen(i, j)
						- getElementoImagen(i+1, j)
						- getElementoImagen(i, j+1)
						- getElementoImagen(i-1, j)
						- getElementoImagen(i, j-1);
				imagenResaltada[i][j] = aux / 8;
			}
		}

	}


	//Devuelve el valor de la matriz 'imagen' en la posición indicada por los parámetros.
	//Si la posición indicada está fuera de la matriz, devuelve cero.
	private static int getElementoImagen(int i, int j){

		int elemento;

		elemento = 0;

		if(i >= 0 && i < imagen.length){
			if(j >= 0 && j < imagen[i].length){
				try{
					elemento = imagen[i][j];
				} catch (IndexOutOfBoundsException e){
					System.err.println(e.toString());
				}
			}
		}

		return elemento;
	}

	
	private static void mostrarImagen(int imagen[][]){

		int i, j;

		System.out.println("La imagen generada es: \n");
		for(i = 0; i < imagen.length; i++){
			for(j = 0; j < imagen[i].length; j++){
				System.out.print(" " + getElementoImagen(i, j) + " ");
			}
			System.out.println("");		
		}
		System.out.println("\n");
	}
		

	//Inicializa la imagen con valores aleatorios de 0 a 19 para
	//representar una escala de 20 tonos de gris.
	private static void inicializarImagen(){

		int i, j;		

		for(i = 0; i < imagen.length; i++){
			for(j = 0; j < imagen[i].length; j++){
				imagen[i][j] = rand.nextInt(20);
			}
		}

	}
}


