import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;

class Estadistica{

    static double[] arrayDatos;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args){

        boolean salir;

        salir = false;
        inicializarArrayDatos(args);

        while(!salir){
            salir = menu();
        }
    }

    private static void inicializarArrayDatos(String[] parametros){

        int i;
        arrayDatos = new double[parametros.length];

        for(i = 0; i < parametros.length; i++){
            arrayDatos[i] = Double.valueOf(parametros[i]);
        }
    }

    private static boolean menu(){

        int seleccion;
        boolean salir;

        mostrarMenu();
        seleccion = getSeleccion();
        
        if(seleccion != 5){
            ejecutar(seleccion);
            salir = false;
        } else{
            salir = true;
        }

        return salir;
    }

    private static void mostrarMenu(){

        System.out.println("\nSeleccione el parámetro estadístico a calcular:"
                            + "\n\t1) Media.\n\t2) Moda.\n\t3) Varianza."
                            + "\n\t4) Desviación típica.\n\t5) Salir.");
    }

    private static void ejecutar(int operacion){

        double resultado;

        switch(operacion){

            case 1: 
                resultado = media();
                break;

            case 2: 
                resultado = moda();
                break;
            
            case 3:
                resultado = varianza();
                break;

            case 4:
                resultado = desviacionTipica();
                break;

            default:
                System.err.println("Se ha producido un error al seleccionar la operación.");
                resultado = 0;
        }

        System.out.println("El resultado del cálculo es " + resultado + ".");
    }

    private static int getSeleccion(){

        int input;
        input = 0;

        do{
            System.out.println("Introduzca una opción válida: ");
            input = teclado.nextInt();
        }while(input < 1 || input > 5);

        return input;
    }

    private static double media(){

        double suma;
        int i;

        suma = 0;

        for(i = 0; i < arrayDatos.length; i++){
            suma = suma + arrayDatos[i];
        }

        suma = suma / arrayDatos.length;

        return suma;
    }

    private static double moda(){

        double contadorMaximo, contadorTemp, valorActual, maximoTemp;
        int i, j;
        boolean primeraIteracion;

        primeraIteracion = true;
        maximoTemp = 0;
        contadorMaximo = 0;

        for(i = 0; i < arrayDatos.length; i++){

            contadorTemp = 0;
            valorActual = arrayDatos[i];

            if(valorActual != maximoTemp || primeraIteracion){
                for(j = 0; j < arrayDatos.length; j++){
                    if(arrayDatos[j] == valorActual){
                        contadorTemp++;
                    }
                }
                primeraIteracion = false;
            }
            if(contadorTemp > contadorMaximo){
                maximoTemp = valorActual;
                contadorMaximo = contadorTemp;
            }
        }

        return maximoTemp;
    }

    private static double varianza(){

        List<Double> visitados;
        double numeroActual, sumatorio, varianza;
        int ocurrenciasDelNumero;
        int i, j;

        visitados = new ArrayList<Double>();
        ocurrenciasDelNumero = 0;
        sumatorio = 0;
        i = 0;

        while(i < arrayDatos.length){
            
            numeroActual = arrayDatos[i];

            if(!visitados.contains(numeroActual)){             //Si no hemos contado ya con el valor actual
                ocurrenciasDelNumero = 1;
                j = i +1;

                while(j < arrayDatos.length){                   //Para cada valor del array, buscamos sus ocurrencias
                    if(arrayDatos[j] == numeroActual){
                        ocurrenciasDelNumero++;
                    }
                    j++;
                }
            }
            
            sumatorio = sumatorio + Math.pow(numeroActual, 2) * ocurrenciasDelNumero;
                //Vamos calculando el sumatorio para el que necesitamos
                // el valor y las veces que se repite dicho valor.

            visitados.add(numeroActual);                        //Una vez calculadas las ocurrencias 
            i++;
        }

        System.out.println("\n" + sumatorio + "\n");

        varianza = (sumatorio / arrayDatos.length) - Math.pow(media(), 2);

        return varianza;
    }

    private static double desviacionTipica(){

        return Math.sqrt(varianza());
    }
}