package P1.e1;

import java.util.Scanner;

public class sistemaSolar
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int i;

        Estrella sol = new Estrella("Sol", 695508.0, 1932891.0, 0.6f);
        Satelite satelites[] = new Satelite[3];
        satelites[0] = new Satelite("Luna", 1737.1, 7349, null);
        satelites[1] = new Satelite("Phobos", 1200.2, 1323.3, null);
        satelites[2] = new Satelite("Europa", 1986.4, 9823, null);
        CuerpoPlanetario planetas[] = new CuerpoPlanetario[8];
    
        planetas[0] = new CuerpoPlanetario("Mercurio", 2439, 3302, false, null, sol);
        planetas[1] = new CuerpoPlanetario("Venus", 6051, 4896, false, null, sol);
        planetas[2] = new CuerpoPlanetario("Tierra", 6371, 5973, true, satelites[0], sol);
        planetas[3] = new CuerpoPlanetario("Marte", 3389, 4185, false, satelites[1], sol);
        planetas[4] = new CuerpoPlanetario("Jupiter", 71492, 499134, false, satelites[2], sol);
        planetas[5] = new CuerpoPlanetario("Saturno", 58323, 56881, false, null, sol);
        planetas[6] = new CuerpoPlanetario("Neptuno", 45022, 45000, false, null, sol);
        planetas[7] = new CuerpoPlanetario("Urano", 30211, 34004, false, null, sol);

        satelites[0].rotaAlrededorDe(planetas[2]);
        satelites[1].rotaAlrededorDe(planetas[3]);
        satelites[2].rotaAlrededorDe(planetas[4]);


        System.out.println("El Sistema Solar tiene " + (planetas.length +1) + " planetas,"
                            + " que orbitan alrededor de la estrella " + sol.nombre()
                            + ";\nque tiene un brillo de " + sol.brillo() + ", un radio de "
                            + sol.radio() + "km, y una masa de " + sol.masa() + "um.\n");

        for (i = 0; i < planetas.length; i++)
        {
            System.out.println("El planeta " + (i+1) + " se llama " + planetas[i].nombre()
                                + ".\n" + "\tTiene una masa de " + planetas[i].masa()
                                + " um, y un radio de " + planetas[i].radio() + "km.");
            
            if (planetas[i].hayVida())
            {
                System.out.println("\tEl planeta está habitado.");
            }
            else {
                System.out.println("\tEl planeta no alberga formas de vida conocidas.");
            }

            if (planetas[i].satelite() != null)
            {
                System.out.println("\tEl planeta tiene un satélite, llamado "
                                    + planetas[i].satelite().nombre() + " que orbita a su alrededor.");
            }
        }

        System.out.println("\nSeleccione un satelite:"
                            + "\n\t1) Luna.\n\t2) Phobos.\n\t3) Europa.");
        do{
            i = teclado.nextInt();
        } while (i < 1 || i > 3);

        System.out.println("El satelite llamado " + satelites[i-1].nombre()
                            + " con un radio de " + satelites[i-1].radio()
                            + "km, y una masa de " + satelites[i-1].masa()
                            + "um, orbita alrededor del planeta " + satelites[i-1].rotaAlrededorDe().nombre() + ".");
        
        teclado.close();
    }


}