package LectorEscritor;

import java.util.concurrent.*;


public class lectorEscritor implements Runnable{

	private static final Object lectores = new Object();
	private static final Object escritores = new Object();
	private static int n = 0;

	private boolean escribiendo = false;
	private int id;
	private boolean tag;

	public lectorEscritor(int i, boolean tag){
		this.id = i;
		this.tag = tag;
	}
									
	public void run(){
		synchronized(lectores){
			if(tag){
				escritor();
			} else{
				lector();
			}
		}
	}

	public void escritor(){
		
		synchronized(escritores){
		
			inicia_escritura();
			fin_escritura();
		}
	}
						  
	public void inicia_escritura(){
		
		synchronized(escritores){
			while(n != 0 || escribiendo){
				try{
					escritores.wait();
				}catch(InterruptedException ex){
					System.err.println(ex.toString());
				}								
		}
	
		escribiendo = true;
		System.out.println("La persona " + (id+1) + " empieza a escribir.");
		}
	}
									
	public void fin_escritura(){

		synchronized(lectores){
			System.out.println("La persona " + (id+1) + " termina de escribir.");
			escribiendo = false;
			lectores.notify();
		}						
	}
						  
	public void lector(){

		synchronized(lectores){
		inicia_lectura();
		fin_lectura();
		}
	}

	public  void inicia_lectura(){

		synchronized(lectores){
			while(escribiendo || n >= 4){
				while(escribiendo){
					try{
						lectores.wait();
					}catch(InterruptedException ex){
						System.err.println(ex.toString());
					}
				}
			}
										
			n++;
			System.out.println("Estan leyendo " + n + " personas.");
		}
	}
								
	public void fin_lectura(){
		
		synchronized(escritores){
			if(n == 4){
				n = 0;
				escritores.notify();
			}	
		}
	}						

}