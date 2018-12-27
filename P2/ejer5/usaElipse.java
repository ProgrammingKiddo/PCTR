package ejer5;


class usaElipse{

	static Elipse myElipse;

	public static void main(String[] args){

		//Elipse myElipse;

		myElipse = new Elipse(4.0, 2.0, 1.5, 2.3);

		imprimirDatosElipse(myElipse);

		probarPunto(5.5, 2.3);
		probarPunto(1.5, 4.3);
		probarPunto(3.2, 7.4);

	}


	private static void imprimirDatosElipse(Elipse elipseLocal){

		System.out.println("Semieje mayor = " + elipseLocal.getSemiejeMayor() +
							"\nSemieje menor = " + elipseLocal.getSemiejeMenor() +
							"\nCentro coordenada X = " + elipseLocal.getCoordXCentro() + 
							"\nCentro coordenada Y = " + elipseLocal.getCoordYCentro() +
							"\nSuperficie = " + elipseLocal.superficie() +
							"\nPerímetro = " + elipseLocal.perimetro());
	}

	private static void probarPunto(double coordX, double coordY){

		System.out.println("¿Está el punto (" + coordX + ", " + coordY + ") en la elipse?");

		if(myElipse.esUnPunto(coordX, coordY)){
			System.out.println("Sí.");
		} else{
			System.out.println("No.");
		}
	}

}
