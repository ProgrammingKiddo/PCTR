/*
 * @author: Borja
 */


import java.lang.Math;


// El programa está hecho según los requisitos del enunciado, para un escenario concreto
// de un cono con unas medidas concretas (diámetro = 14,2 cm , altura = 20 cm).


public class Circulo {

	
	public static void main(String[] args) {
		
		final double pi = Math.PI;
		double diametro, altura, resultado;
		
		diametro = 14.2;
		altura = 20;
		resultado = (pi * Math.pow(diametro/2, 2)) * altura / 3;
		
		System.out.println("El volumen para el cono dado en el enunciado es de " + resultado +
				" centímetros cúbicos.");
	}

}
