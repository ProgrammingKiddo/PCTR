package ejer1y2;

class Triangulo extends Poligono{


	//Para la correcta operación de la clase es necesario
	//que el array de puntos pasado al constructor represente
	//un triángulo equilátero.
	public Triangulo(Punto[] arrayPuntos){

		super(arrayPuntos);
	}

	
	public double area(){

		double base, altura;

		base = puntos[0].distancia(puntos[1]);
		altura = Math.pow(base/2, 2) + Math.pow(base/2, 2);
		altura = Math.sqrt(altura);

		return (base * altura) / 2;
	}

}