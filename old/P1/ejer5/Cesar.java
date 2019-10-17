import java.util.Scanner;

/*
 * @author: Borja
 */

public class Cesar {

	public static void main(String[] args){
		
		String textoPlano, textoCifrado;
		Scanner keyboardScanner;
		int clave;
		

		System.out.print("Introduzca el texto que desea cifrar: ");
		keyboardScanner = new Scanner(System.in);
		textoPlano = keyboardScanner.next();
		
		System.out.print("Introduzca la clave con la que cifrar el texto: ");
		clave = keyboardScanner.nextInt();
		keyboardScanner.close();
		

		textoCifrado = cifrarTexto(textoPlano, clave);
		

		System.out.println("Su texto cifrado es : " + textoCifrado);
	}
	
	
	private static String cifrarTexto(String textoPlano, int clave) {
		
		int valorDelCaracter, i;
		char caracter;
		String textoCifrado;
		
		textoCifrado = "";
		
		for(i = 0; i < textoPlano.length(); i++) {
			
			caracter = textoPlano.charAt(i);
			valorDelCaracter = Integer.valueOf(caracter);

			valorDelCaracter = valorDelCaracter + clave % 27;
			caracter = (char) valorDelCaracter;

			textoCifrado = textoCifrado + caracter;
		}
		
		return textoCifrado;
	}
}
