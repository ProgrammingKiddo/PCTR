package P2.e4;

class redCajeros
{

    public static void main(String[] args)
    {
        int resultado;

        cuentaCorriente objCC = new cuentaCorriente(1000);
        Thread hilo1 = new Thread(new cajero(objCC, 10000, true));
        Thread hilo2 = new Thread(new cajero(objCC, 10000, false));

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException ex){
            System.out.println(ex.toString());
        }

        resultado = objCC.verBalance();
        System.out.println("El resultado de los cajeros es " + resultado + ".");
    }
}