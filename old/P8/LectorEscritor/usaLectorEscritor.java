package LectorEscritor;

import java.util.concurrent.*;
import java.util.Scanner;

public class usaLectorEscritor{

	
	
	public static void main(String[] args){

		Scanner teclado;
		int n_lectores, n_escritores, i;

		teclado = new Scanner(System.in);
		
		System.out.println("¿Cuantos lectores hay?");
		n_lectores  = teclado.nextInt();
		System.out.println("Cuantos escritores hay?");
		n_escritores = teclado.nextInt();
		
		ExecutorService exec = Executors.newCachedThreadPool();

		//Lanzamos los escritores primero.
		for(i = 1; i < n_escritores; i++){
			exec.execute(new lectorEscritor(i,true));
		}	

		//A continuación lanzamos los lectores.
		for(i = 0; i < n_lectores; i++){
			exec.execute(new lectorEscritor(i,false));
		}
        
        try{
            exec.shutdown();
        } catch(SecurityException ex){
            System.err.println(ex.toString());
        }
	}
	
}