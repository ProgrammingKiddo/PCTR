package P2.e4;

class cuentaCorriente
{
    private int _balance;

    public cuentaCorriente(int balance)
    {
        _balance = balance;
    }

    // cantidad puede ser un valor negativo
    public void modificar(int cantidad)
    {
        _balance = _balance + cantidad;
    }

    public int verBalance()
    {
        return _balance;
    }

}