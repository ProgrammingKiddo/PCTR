package ejer5;

class Elipse{

	//Inicializamos los atributos a 0 por defecto, para prevenir errores
	//en caso de crear el objeto sin pasarle los argumentos apropiados
	double semiejeMayor = 0,
			semiejeMenor = 0,
			centroCoordX = 0,
			centroCoordY = 0;


	public Elipse(double semiejeMayor, double semiejeMenor, double centroCoordX, double centroCoordY){

		this.semiejeMayor = semiejeMayor;
		this.semiejeMenor = semiejeMenor;
		this.centroCoordX = centroCoordX;
		this.centroCoordY = centroCoordY;
	}


	//Devuelve verdadero si el punto representado por las coordenadas pasadas
	//como argumento está en la línea dibujada por la elipse (no dentro).
	public boolean esUnPunto(double coordX, double coordY){

		boolean esPunto;
		double resultadoCalculo;

		resultadoCalculo = Math.pow(coordX - centroCoordX, 2) / Math.pow(semiejeMayor, 2);
		resultadoCalculo = resultadoCalculo +  Math.pow(coordY - centroCoordY, 2) / Math.pow(semiejeMenor, 2);

		if(resultadoCalculo == 1){
			esPunto = true;
		} else{
			esPunto = false;
		} 
		
		return esPunto;
	}


	public double superficie(){

		return  Math.PI * semiejeMayor * semiejeMenor;
	}

	public double perimetro(){

		double resultado;

		resultado = (Math.pow(semiejeMayor, 2) + Math.pow(semiejeMenor, 2)) / 2;
		resultado = 2 * Math.PI * Math.sqrt(resultado);

		return resultado;

	}


	public double getSemiejeMayor(){

		return semiejeMayor;
	}

	public double getSemiejeMenor(){

		return semiejeMenor;
	}

	public double getCoordXCentro(){

		return centroCoordX;
	}

	public double getCoordYCentro(){

		return centroCoordY;
	}


}
