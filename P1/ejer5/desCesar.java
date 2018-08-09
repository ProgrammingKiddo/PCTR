import java.util.Scanner;

/*
 * @author: Borja
 */

public class desCesar {

	public static void main(String[] args){
		
		String textoPlano, textoCifrado;
		Scanner keyboardScanner;
		int clave;
		

		System.out.print("Introduzca el texto que desea descifrar: ");
		keyboardScanner = new Scanner(System.in);
		textoCifrado = keyboardScanner.next();
		
		System.out.print("Introduzca la clave con la que descifrar el texto: ");
		clave = keyboardScanner.nextInt();
		keyboardScanner.close();
		

		textoPlano = descifrarTexto(textoCifrado, clave);
		

		System.out.println("Su texto descifrado es : " + textoPlano);
	}
	
	
	private static String descifrarTexto(String textoCifrado, int clave) {
		
		int valorDelCaracter, i;
		char caracter;
		String textoPlano;
		
		textoPlano = "";
		
		for(i = 0; i < textoCifrado.length(); i++) {
			
			caracter = textoCifrado.charAt(i);
			valorDelCaracter = Integer.valueOf(caracter);

			valorDelCaracter = valorDelCaracter - clave % 27;
			caracter = (char) valorDelCaracter;

			textoPlano = textoPlano + caracter;
		}
		
		return textoPlano;
	}
}
