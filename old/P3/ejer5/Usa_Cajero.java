import java.util.Scanner;
public class Usa_Cajero{
	
	public static void main(String[] args)throws Exception {
		
		Scanner sc = new Scanner(System.in);	
	
		int n,i;
		double res,dinero,inicio;
		System.out.println("Cual es el maximo de cajeros que quieres? ");
		n=sc.nextInt();
		Thread [] hilos1 = new Thread[n];
		Thread [] hilos2 = new Thread[n];
		//double [] inicio = new double[n];
		//double [] dinero = new double[n];
		
		do{
		
		System.out.println("Que cajero quieres? ");
		System.out.println("Pulsa un numero menor que 0 para salir");
		i=sc.nextInt();
		i=i-1;
		if(i>=n || i<0) System.out.println("No existe ese cajero");
		else{
		System.out.println("Cual es su saldo inicial? ");
		inicio=sc.nextDouble();
		System.out.println("Cuanto de desea extraer/añadir? ");
		dinero=sc.nextDouble();
		hilos1[i] = new Thread(new Cajero(inicio,1,dinero));
		hilos2[i] = new Thread(new Cajero(inicio,2,dinero));
		hilos1[i].start();
		hilos2[i].start();
		hilos1[i].join();
		hilos2[i].join();
		
		System.out.println("\n");			

			}
		}while(i>=0);
											}
	
						}