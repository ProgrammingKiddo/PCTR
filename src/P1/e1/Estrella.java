package P1.e1;


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