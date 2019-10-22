package ejer1y2;

class Cuadrado extends Poligono{


	public Cuadrado(Punto[] arrayPuntos){

		super(arrayPuntos);
	}


	public double area(){
		
		double area;

		area = puntos[0].distancia(puntos[1]);
		area = Math.pow(area, 2);

		return area;
	}

	public double longDiagonal(){

		double diagonal;

		diagonal = puntos[0].distancia(puntos[2]);
		//En un cuadrado dos puntos no consecutivos cualesquiera
		//forman una diagonal que lo atraviesa.

		return diagonal;
	}
}