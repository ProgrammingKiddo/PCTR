/*
 * @author: Borja
 * @version: 1.0
 */

package ejer1;

import java.util.Scanner;
import java.lang.String;

class Biblioteca{

	static Scanner keyboardScanner = new Scanner(System.in);

	private static Paciente[] biblioteca = new Paciente[50];


	public static void main(String[] args){

		boolean repetir;

		System.out.println("Para empezar a utilizar la base de datos, debe introducir al menos un paciente.\n");
		insertarPaciente();


		repetir = true;

		while(repetir){
			repetir = menu();
		}
		
	}

	private static boolean menu(){

		boolean repetir;
		int operacion;

		repetir = false;

		mostrarMenu();
		operacion = Integer.valueOf(getDato("Operación"));
		repetir = ejecutarOperacion(operacion);

		return repetir;
	}

	private static void mostrarMenu(){

		System.out.println("Seleccione qué operación desea realizar en la base de datos:\n"+
							"\t1) Insertar nuevo paciente.\n\t2) Borrar paciente existente.\n"+
							"\t3) Consultar los datos de un paciente.\n"+
							"\t4) Listar todos los pacientes.\n\t5) Salir.");
	}

	private static boolean ejecutarOperacion(int operacion){

		boolean repetir;

		repetir = true;

		switch(operacion){
			case 1:
				insertarPaciente();
				break;
			case 2:
				borrarPaciente();
				break;
			case 3:
				mostrarPaciente();
				break;
			case 4:
				listarPacientes();
				break;
			default:
				repetir = false;
				break;
		}
		return repetir;
	}

	private static void insertarPaciente(){

		int index;

		index = buscarHueco();

		if(index >= 0){
			biblioteca[index] = getNewPaciente();
			System.out.println("\nEl paciente " + biblioteca[index].getNombre() + " fue insertado con éxito en la base de datos.\n");
		} else{
			System.out.println("\nLo lamentamos, no hay hueco en la base de datos para insertar a este nuevo paciente.\n");
		}
	}

	private static void borrarPaciente(){

		int index;

		index = buscarPaciente();

		if(index >= 0){
			System.out.println("El paciente con DNI " + biblioteca[index].getDNI() + " ha sido borrado satisfactoriamente.\n");
			biblioteca[index] = null;
		} else{
			System.out.println("No se ha encontrado al en la base de datos.\n");
		}
	}

	private static void mostrarPaciente(){

		int index;

		index = buscarPaciente();

		if(index >= 0){
			mostrarDatosPaciente(index);
		}
		else{
			System.out.println("\nLo sentimos, ese paciente no existe.");
		}

	}

	private static void listarPacientes(){

		int i;

		i = 0;

		while(i < biblioteca.length){
			if(biblioteca[i] != null){
				mostrarDatosPaciente(i);
			}
		}
		
	}

	private static int buscarHueco(){

		int index;
		boolean encontradoHueco;

		index = 0;
		encontradoHueco = false;

		while(index < biblioteca.length && encontradoHueco == false){

			if(biblioteca[index] == null){
				encontradoHueco = true;
			} else{
				index++;
			}
		}

		if(!encontradoHueco){
			index = -1;
		}

		return index;
	}


	// @param: none
	// @return: Devuelve el índice del vector Biblioteca donde se encuentra el paciente con el mismo
	//nombre que el pasado por parámetro.
	//Si no lo encuentra, devuelve -1.
	private static int buscarPaciente(){

		int index, metodoBusqueda;
		boolean encontradoPaciente;
		String parametroBusqueda;

		index = 0;
		encontradoPaciente = false;

		metodoBusqueda = getMetodoBusqueda();
		parametroBusqueda = getParametroBusqueda(metodoBusqueda);


		while(index < biblioteca.length && encontradoPaciente == false){

			if(contrastarPaciente(parametroBusqueda, index, metodoBusqueda)){
				encontradoPaciente = true;
				System.out.println("\nEncontrado!");
			} else{
				index++;
			}
		}
		if(!encontradoPaciente){
			index = -1;
		}

		return index;
	}

	private static int getMetodoBusqueda(){

		int parametro;

		mostrarParametrosBusqueda();
		do{
			parametro = Integer.valueOf(getDato("Parámetro de búsqueda"));
		}while(parametro < 1 || parametro > 4);

		return parametro;
	}

	private static void mostrarParametrosBusqueda(){

		System.out.println("Seleccione el parámetro mediante el que buscar el paciente:"+
							"\n\t1) Número de la Seguridad Social.\n\t2) Nombre.\n\t3) DNI."+
							"\n\t4) Dirección.\n"); 
	}

	private static String getParametroBusqueda(int metodo){

		String parametro;

		switch(metodo){
			case 1:
				parametro = getDato("Número de la Seguridad Social");
				break;
			case 2:
				parametro = getDato("Nombre");
				break;
			case 3:
				parametro = getDato("DNI");
				break;
			case 4:
				parametro = getDato("Dirección");
				break;
			default:
				parametro = null;
				break;
		}

		return parametro;
	}

	private static boolean contrastarPaciente(String dato, int indice, int metodoBusqueda){

		boolean coincide;
		Paciente paciente;

		paciente = biblioteca[indice];
		coincide = false;

		//if paciente != null

		if(paciente != null){

			switch(metodoBusqueda){
				case 1:
					if(paciente.getNumeroSS().equals(dato))
						coincide = true;
					break;
				case 2:
					if(paciente.getNombre().equals(dato))
						coincide = true;
					break;
				case 3:
					if(paciente.getDNI().equals(dato))
						coincide = true;
					break;
				case 4:
					if(paciente.getDireccion().equals(dato))
						coincide = true;
					break;
				default:
					System.err.println("No ha introducido un parámetro de búsqueda válido.");
					break;
			}
		}

		return coincide;
	}

	private static Paciente getNewPaciente(){

		Paciente nuevoPaciente;
		String dni, telefono, edad, numeroSS,
				nombre, direccion, aseguradora, sexo;

		System.out.println("Se ha encontrado hueco en la base de datos para insertar un paciente;"
							+ "\npor favor, facilítenos sus datos:\n");
		
		dni = getDato("DNI");
		nombre = getDato("Nombre");
		edad = getDato("Edad");
		sexo = getDato("Sexo");
		direccion = getDato("Dirección");
		telefono = getDato("Teléfono");
		aseguradora = getDato("Aseguradora");
		numeroSS = getDato("Número de la seguridad social");

		nuevoPaciente = new Paciente(telefono, edad, numeroSS, dni, nombre, direccion, aseguradora, sexo);
		
		return nuevoPaciente;
	}


	private static String getDato(String nombreDelDato){

		String dato;

		System.out.print(nombreDelDato + ": ");
		dato = keyboardScanner.nextLine();

		return dato;
	}

	private static void mostrarDatosPaciente(int index){

		Paciente pacienteLocal;
		String[] patologias;
		int i;

		pacienteLocal = biblioteca[index];
		patologias = pacienteLocal.getDiagnostico();

		System.out.print("Ficha del paciente " + index
							+ "\n\tDNI: " + pacienteLocal.getDNI()
							+ "\n\tNombre: " + pacienteLocal.getNombre()
							+ "\n\tEdad: " + pacienteLocal.getEdad()
							+ "\n\tSexo: " + pacienteLocal.getSexo()
							+ "\n\tDireccion: " + pacienteLocal.getDireccion()
							+ "\n\tTelefono: " + pacienteLocal.getTelefono()
							+ "\n\tAseguradora: " + pacienteLocal.getAseguradora()
							+ "\n\tNumero de la Seguridad Social: " + pacienteLocal.getNumeroSS());

		System.out.println("\n\n\tDiagnóstico del paciente:");

		if(patologias != null){
			for(i = 0; i < patologias.length; i++){
				System.out.print("\n\t\t" + patologias[i]);
			}
		}
		else{
			System.out.print("Nada de momento.");
		}
	}









	
}
