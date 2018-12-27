package dgt;

class Conductor {

	
	//Constructor
	
	Conductor(String nombre, String dni, int edad, int puntos) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.puntos = puntos;
	}
	
	//Métodos del paquete
	
	String getNombre() {
		return nombre;
	}
	
	String getDNI() {
		return dni;
	}
	
	int getEdad() {
		return edad;
	}
	
	int getPuntos() {
		return puntos;
	}
	
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	void setDNI(String dni) {
		this.dni = dni;
	}
	
	void setEdad(int edad) {
		this.edad = edad;
	}
	
	void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	//Atributos privados
	
	private String nombre,
			dni;
	
	private int edad,
		puntos;
	
}
