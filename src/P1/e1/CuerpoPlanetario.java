package P1.e1;

public class CuerpoPlanetario extends CuerpoAstrofisico
{
    // Constructores
    CuerpoPlanetario(String nombre, double radio, double masa, boolean hayVida, Satelite satelite, Estrella estrella)
    {
        super(nombre, radio, masa);
        _hayVida = hayVida;
        _satelite = satelite;
        _estrella = estrella;
    }
    CuerpoPlanetario(CuerpoAstrofisico c, boolean hayVida, Satelite satelite, Estrella estrella)
    {
        super(c.nombre(), c.radio(), c.masa());
        _hayVida = hayVida;
        _satelite = satelite;
        _estrella = estrella;
    }

    // Métodos observadores
    public boolean hayVida() { return _hayVida; }
    public Satelite satelite() { return _satelite; }
    public Estrella estrella() { return _estrella; }

    // Atributos
    private boolean _hayVida;
    private Satelite _satelite;
    private Estrella _estrella;
}