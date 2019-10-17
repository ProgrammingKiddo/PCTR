package P1.e1;

import java.util.Scanner;


public class CuerpoAstrofisico
{
    // Constructores
    CuerpoAstrofisico(String nombre, double radio, double masa)
    {
        _nombre = nombre;
        _radio = radio;
        _masa = masa;
    }

    // Métodos observadores
    public String nombre() { return _nombre; }
    public double radio() { return _radio; }
    public double masa() { return _masa; }

    // Atributos
    private String _nombre;
    private double _radio;
    private double _masa;
}


public class Estrella extends CuerpoAstrofisico
{
    // Constructores
    Estrella(String nombre, double radio, double masa, float brillo)
    {
        super(nombre, radio, masa);
        _brillo = brillo;
    }
    Estrella(CuerpoAstrofisico c, float brillo)
    {
        super(c.nombre(), c.radio(), c.masa());
        _brillo = brillo;
    }

    // Métodos observadores
    public float brillo() { return _brillo; }

    // Atributos
    private float _brillo;
}

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
        super(c.nombre(), c.radio, c.masa());
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

    // Métodos observadores
    public CuerpoPlanetario rotaAlrededorDe() { return centroRotativo; }
    public void rotaAlrededorDe(CuerpoPlanetario c) { _centroRotativo = c; }

    // Atributos
    private CuerpoPlanetario _centroRotativo;
}