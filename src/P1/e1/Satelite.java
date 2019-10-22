package P1.e1;

public class Satelite extends CuerpoAstrofisico
{
    // Constructores
    Satelite(String nombre, double radio, double masa, CuerpoPlanetario centroRotativo)
    {
        super(nombre, radio, masa);
        _centroRotativo = centroRotativo;
    }
    Satelite(CuerpoAstrofisico c, CuerpoPlanetario centroRotativo)
    {
        super(c.nombre(), c.radio(), c.masa());
        _centroRotativo = centroRotativo;
    }

    // Método observador
    public CuerpoPlanetario rotaAlrededorDe() { return _centroRotativo; }
    // Método modificador
    public void rotaAlrededorDe(CuerpoPlanetario c) { _centroRotativo = c; }

    // Atributos
    private CuerpoPlanetario _centroRotativo;
}