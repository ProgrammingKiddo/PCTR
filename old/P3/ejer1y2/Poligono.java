package ejer1y2;

class Poligono{

	Punto[] puntos;

	public Poligono(){
		puntos = null;
	}

	public Poligono(Punto[] arrayPuntos){

		int index;

		puntos = new Punto[arrayPuntos.length];

		for(index = 0; index < arrayPuntos.length; index++){
			puntos[index] = arrayPuntos[index];
		}
		
	}

	public int numeroDeLados(){

		return puntos.length;
	}

	public float perimetro(){

		int index;
		float perimetro;

		perimetro = 0;

		for(index = 0; index < (puntos.length -1); index++){
			perimetro += puntos[index].distancia(puntos[index+1]);
		}
		perimetro += puntos[index].distancia(puntos[0]);

		return perimetro;
	}

	public void escalado(float factorEscalado){

		int index;

		for(index = 0; index < puntos.length; index++){
			puntos[index].coordX = puntos[index].coordX * factorEscalado;
			puntos[index].coordY = puntos[index].coordY * factorEscalado;
		}
	}

	public void desplazarX(float distanciaX){

		int index;

		for(index = 0; index < puntos.length; index++){
			puntos[index].coordX = puntos[index].coordX + distanciaX;
		}
	}

	public void desplazarY(float distanciaY){

		int index;

		for(index = 0; index < puntos.length; index++){
			puntos[index].coordY = puntos[index].coordY + distanciaY;
		}
	}

	public String toString(){

		String cadena;
		int index;

		cadena = "{";

		for(index = 0; index < puntos.length; index++){
			cadena += puntos[index].toString() + ", ";
		}
		cadena += "}";
		
		return cadena;
	}


}