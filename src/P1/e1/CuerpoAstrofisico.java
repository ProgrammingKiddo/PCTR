package P1.e1;


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