/*
 * @author: Borja
 * @version: 1.0
 */

package ejer4;

class Complejos{

	private float[] complejo = new float[2];

	//Constructor con parámetros, para crear el complejo deseado.
	Complejos(float parteReal, float parteImaginaria){

		complejo[0] = parteReal;
		complejo[1] = parteImaginaria;
	}

	//Constructor por defecto, en caso de que no se pasen parámetros.
	Complejos(){

		complejo[0] = 0;
		complejo[1] = 0;
	}

	/************************************/
	/*		OPERACIONES ARITMÉTICAS		*/
	/************************************/

	Complejos sumaComplejos(Complejos sumando){

		Complejos suma;
		float resultadoReal, resultadoImaginario;

		resultadoReal = complejo[0] + sumando.getParteReal();
		resultadoImaginario = complejo[1] + sumando.getParteImaginaria();

		suma = new Complejos(resultadoReal, resultadoImaginario);

		return suma;
	}

	Complejos restaComplejos(Complejos sustraendo){

		Complejos diferencia;
		float resultadoReal, resultadoImaginario;

		resultadoReal = complejo[0] - sustraendo.getParteReal();
		resultadoImaginario = complejo[1] - sustraendo.getParteImaginaria();

		diferencia = new Complejos(resultadoReal, resultadoImaginario);

		return diferencia;
	}

	Complejos productoComplejos(Complejos factor){

		Complejos producto;
		float resultadoReal, resultadoImaginario;

		//(a*c - b*d) Parte real
		resultadoReal = (complejo[0] * factor.complejo[0]) - (complejo[1] * factor.complejo[1]);
		//(a*d + b*c) Parte imaginaria
		resultadoImaginario = (complejo[0] * factor.complejo[1] + complejo[1] * factor.complejo[0]);

		producto = new Complejos(resultadoReal, resultadoImaginario);

		return producto;
	}

	Complejos cocienteComplejos(Complejos divisor){

		Complejos cociente;
		float resultadoReal, resultadoImaginario;

		resultadoReal = (complejo[0] * divisor.complejo[0] + complejo[1] * divisor.complejo[1]);
		resultadoReal = resultadoReal / (float) (Math.pow(divisor.complejo[0], 2) + Math.pow(divisor.complejo[1], 2));

		resultadoImaginario = (complejo[1] * divisor.complejo[0] - complejo[0] * divisor.complejo[1]);
		resultadoImaginario = resultadoImaginario / (float) (Math.pow(divisor.complejo[0], 2) + Math.pow(divisor.complejo[1], 2));

		cociente = new Complejos(resultadoReal, resultadoImaginario);

		return cociente;
	}

	//Devuelve el módulo del complejo que llama al método.
	float modulo(){

		float modulo;

		modulo = (float) Math.pow(complejo[0], 2) + (float) Math.pow(complejo[1], 2);
		modulo = (float) Math.sqrt(modulo);

		return modulo;
	}

	//Devuelve el conjugado del complejo que llama al método.
	Complejos conjugado(){

		Complejos conjugado;

		conjugado = new Complejos(complejo[0], -complejo[1]);

		return conjugado;
	}

	float getParteReal(){

		return complejo[0];
	}

	float getParteImaginaria(){

		return complejo[1];
	}

	String toString(){

		String parteReal, parteImaginaria, cadena;

		parteReal = "";
		parteImaginaria = "";
		cadena = "0";

		if(complejo[0] != 0){
			parteReal = String.valueOf(complejo[0]);
		}

		if(complejo[1] != 0){
			if(complejo[1] > 0){
				parteImaginaria += "+";
			}
			if(complejo[1] != 1){
				parteImaginaria += String.valueOf(complejo[1]);
			}
			parteImaginaria += "i";
		}
					
		cadena = parteReal + parteImaginaria;

		return cadena;
	}

}
