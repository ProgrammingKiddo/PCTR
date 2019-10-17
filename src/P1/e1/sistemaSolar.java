package P1.e1;

import java.util.Scanner;
import java.util.*;

public class sistemaSolar
{

    public static void main(String[] args)
    {
        Estrella sol = new Estrella("Sol", 695508, 1932891, 0.6);
        Satelite luna = new Satelite("Luna", 1737.1, 7349, null);
        CuerpoPlanetario planetas[] = new CuerpoPlanetario[8];
    
        planetas[0] = new CuerpoPlanetario("Mercurio", 2439, 3302, false, null, sol);
        planetas[1] = new CuerpoPlanetario("Venus", 6051, 4896, false, null, sol);
        planetas[2] = new CuerpoPlanetario("Tierra", 6371, 5973, true, luna, sol);
        planetas[3] = new CuerpoPlanetario("Marte", 3389, 4185, false, null, sol);
        planetas[4] = new CuerpoPlanetario("Jupiter", 71492, 499134, false, null, sol);
        planetas[5] = new CuerpoPlanetario("Saturno", 58323, 56881, false, null, sol);
    }


}