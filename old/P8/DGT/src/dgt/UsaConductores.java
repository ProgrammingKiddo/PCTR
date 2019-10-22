package dgt;

import java.util.Random;
import java.lang.Thread;

public class UsaConductores extends Thread {

	static Conductores dgt = new Conductores();
	int conductor;
	
	UsaConductores(int number){
		conductor = number;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsaConductores obj1,
						obj2,
						obj3,
						obj4;
		Thread hilo1,
				hilo2,
				hilo3,
				hilo4;

		dgt.nuevoConductor("Pablo", "33125740L", 24, 12);
		dgt.nuevoConductor("Borja", "32080365B", 20, 15);
		dgt.nuevoConductor("Lu", "56453213W", 22, 9);
		dgt.nuevoConductor("Ermenegildo López", "21400054Y", 72, 2);
		
		obj1 = new UsaConductores(0);
		obj2 = new UsaConductores(1);
		obj3 = new UsaConductores(2);
		obj4 = new UsaConductores(3);
		
		hilo1 = new Thread(obj1);
		hilo2 = new Thread(obj2);
		hilo3 = new Thread(obj3);
		hilo4 = new Thread(obj4);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		} catch (InterruptedException e) {
			System.err.println(e.toString());
		}

		System.out.println("\n\tTodos los conductores han terminado sus viajes, de un modo u otro.");
		
	
}

	public void run() {
		
		int distancia, i;
		boolean accidente;
		Random rand;
		
		rand = new Random();
		accidente = false;
		distancia = rand.nextInt(10);
		i = 0;
		
		while(i <= distancia && !accidente) {
			if(rand.nextInt(20) == 0) {
				dgt.accidente(conductor);
				accidente = true;
			}
			i++;
		}
		if(!accidente) {
			dgt.destino(conductor);
		}
		
		
	}
}
