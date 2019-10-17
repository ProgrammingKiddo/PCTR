package ejer1y2;

import java.lang.*;

class Punto{


	double coordX, coordY;


	Punto(double coordX, double coordY){

		this.coordX = coordX;
		this.coordY = coordY;
	}


	public void moverEn(double direccionX, double direccionY){

		coordX += direccionX;
		coordY += direccionY;
	}

	public double distanciaOrigen(){

		double distancia;
		Punto cero;

		cero = new Punto(0, 0);

		distancia = distancia(cero);

		return distancia;
	}

	public double distancia(Punto p){

		double distancia, vectorHoriz, vectorVertic;

		vectorHoriz = coordX - p.coordX;
		vectorVertic = coordY - p.coordY;

		distancia = Math.pow(vectorHoriz, 2) + Math.pow(vectorVertic, 2);
		distancia = Math.sqrt(distancia);

		return distancia;
	}


	public int cuadrante(){

		int cuadrante;

		if(coordX >= 0){
			if(coordY >= 0){
				cuadrante = 1;
			} else{
				cuadrante = 4;
			}
		} else{
			if(coordY >= 0){
				cuadrante = 2;
			} else{
				cuadrante = 3;
			}
		}

		return cuadrante;
	}

	public double getX(){

		return coordX;
	}

	public double getY(){
		return coordY;
	}

	public String toString(){

		String cadena;

		cadena = "(" + Double.toString(coordX) + ", " + Double.toString(coordY) + ")";

		return cadena;
	}
}