/*
 *@author: Borja
 */

package ejer1;

class Paciente{


	private String dni,
		edad,
		nombre,
		direccion,
		sexo,
		telefono,
		numeroSeguridadSocial,
		aseguradora;

	private String[] diagnostico;

	Paciente(String numTELF, String age, String numeroSS,
			String numDNI, String nombreParametro, String direccionParametro,
			String aseguradoraParametro, String sexoParametro){

		telefono = numTELF;
		edad = age;
		numeroSeguridadSocial = numeroSS;
				
		dni = numDNI;
		nombre = nombreParametro;
		direccion = direccionParametro;
		aseguradora = aseguradoraParametro;
		sexo = sexoParametro;
	}

	
	String getTelefono(){
		return telefono;
	}
	
	String getEdad(){
		return edad;
	}
	
	String getNumeroSS(){
		return numeroSeguridadSocial;
	}
	
	String getDNI(){
		return dni;
	}

	String getNombre(){
		return nombre;
	}

	String getDireccion(){
		return direccion;
	}

	String getSexo(){
		return sexo;
	}

	String getAseguradora(){
		return aseguradora;
	}

	String[] getDiagnostico(){
		return diagnostico;
	}
}
