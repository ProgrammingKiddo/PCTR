package dgt;

public class Conductores {

	private Conductor[] baseDatos = new Conductor[30];
	private int numeroConductores = 0;
	
	//Métodos del paquete
	
	synchronized void nuevoConductor(String nombre, String dni, int edad, int puntos) {
		
		int indice;
		
		if(numeroConductores < 30) {
			indice = buscarHueco();
			baseDatos[indice] = new Conductor(nombre, dni, edad, puntos);
		}
		
		numeroConductores++;
	}
	
	synchronized void destino(int conductor) {
		
		System.out.println("El conductor " + baseDatos[conductor].getNombre() +
							" con DNI" + baseDatos[conductor].getDNI() + " ha llegado a su destino.");
	}
	
	synchronized void accidente(int conductor) {
		
		System.out.println("El conductor " + baseDatos[conductor].getNombre() +
							" con DNI" + baseDatos[conductor].getDNI() +
							" ha cometido una infracción de camino a su destino.\n"+
							"\tSe le han restado 2 puntos del carnet.");
	}
	
	//Busca el primero elemento del array de conductores que no tiene ningún objeto
	//(null) y devuelve su índice.
	private int buscarHueco() {
		
		int indice;
		boolean encontradoHueco;
		
		indice = 0;
		encontradoHueco = false;
		
		while(indice <= baseDatos.length && encontradoHueco == false) {
			if(baseDatos[indice] == null) {
				encontradoHueco = true;
			}
			else {
				indice++;
			}
		}
		
		return indice;
	}
	
}
