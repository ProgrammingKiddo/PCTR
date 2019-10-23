package P2.e4;




class cajero implements Runnable
{
    private cuentaCorriente _miCC;
    private int _nIteraciones;
    private boolean _suma;

    public cajero(cuentaCorriente miCC, int nIteraciones, boolean suma)
    {
        _miCC = miCC;
        _nIteraciones = nIteraciones;
        _suma = suma;
    }

    public void run()
    {
        int i;

        for (i = 0; i < _nIteraciones; i++)
        {
            if (_suma)
            {
                _miCC.modificar(1);
            }
            else
            {
                _miCC.modificar(-1);
            }
        }
    }
}