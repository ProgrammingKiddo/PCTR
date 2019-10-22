
/*
 * @author: Borja
 * @version: 1.0
 * 
 * A(m,n){
 *      n+1 ; si m==0
 *      A(m-1,1) ; si m>0 y n==0
 *      A(m-1,A(m,n-1)) ; si m>0 y n>0
 * }
 */

class Ack{


    public static void main(String[] args){

        int n, m, result;

        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);

        result = ackerman(m, n);

        System.out.println("Para los valores n=" + n +" y m=" + m + " la función de Ackerman vale " + result + ".");
    }

    private static int ackerman(int m, int n){

        if(m == 0){
            return n+1;
        } else{
            if(m > 0 && n == 0){
                return ackerman(m-1, 1);
            } else{
                if(m > 0 && n > 0){
                    return ackerman(m-1, ackerman(m, n-1));
                } else{
                    return 0;
                }
            }
        }
    }
}
