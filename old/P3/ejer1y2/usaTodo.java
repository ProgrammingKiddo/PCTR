package ejer1y2;

import java.util.Scanner;

class usaTodo{

    static Scanner teclado = new Scanner(System.in);
    static Punto[] arrayPuntos;
    static Poligono myPoligono;
    static Poligono poligonoReferencia = new Poligono();

    public static void main(String[] args){
        
        crearArrayPuntos();
        crearPoligono();

        mostrarMenu();

        teclado.close();
    }

    private static void crearPoligono(){

        switch(arrayPuntos.length){
            case 3:
                myPoligono = new Triangulo(arrayPuntos);
                break;

            case 4:
                myPoligono = new Cuadrado(arrayPuntos);
                break;

            case 5:
                myPoligono = new Pentagono(arrayPuntos);
                break;

            case 6:
                myPoligono = new Hexagono(arrayPuntos);
                break;

            default:
                myPoligono = new Poligono(arrayPuntos);
                break;
        }
    }

    private static void crearArrayPuntos(){

        saludar();
        inicializarArray();
        rellenarArrayPuntos();
    }

    private static void inicializarArray(){

        int capacidad;

        capacidad = pedirNumeroPuntos();

        arrayPuntos = new Punto[capacidad];
    }

    private static int pedirNumeroPuntos(){

        int capacidad;

        do{
            System.out.print("Introduzca el número de vértices que componen el polígono: ");
            capacidad = teclado.nextInt();
            if(capacidad <= 2){
                System.err.println("Error, introduzca un número entero mayor que dos.");
            }
        }while(capacidad <= 2);

        return capacidad;
    }

    private static void rellenarArrayPuntos(){

        int index;
        Punto temp;

        index = 0;

        while(index < arrayPuntos.length){
            temp = pedirPunto();
            arrayPuntos[index] = temp;
            index++;
        }
    }

    private static Punto pedirPunto(){

        Punto nuevoPunto;
        double coordX, coordY;

        coordX = pedirCoordenada("X");
        coordY = pedirCoordenada("Y");

        nuevoPunto = new Punto(coordX, coordY);

        return nuevoPunto;
    }

    private static double pedirCoordenada(String eje){

        double coordenada;

        System.out.print("Introduce la coordenada "+ eje +" del punto: ");
        coordenada = teclado.nextDouble();

        return coordenada;
    }


    /*  METODOS VERBOSE     */

    private static void saludar(){

        System.out.println("\n\t***Menú de gestión de Polígonos***\n"+
                            "\nPara empezar a trabajar debe crear un nuevo polígono introduciendo las coordenadas\n"+
                            "de sus puntos. Recuerde que debe introducir al menos tres puntos.");
    }

    private static void mostrarMenu(){
        System.out.println(myPoligono instanceof Triangulo);
    }
}