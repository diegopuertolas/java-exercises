package Ejercicios.POO.EjercicioHerencia;

public class Piso extends Inmueble {

    // Propiedades
    private int m_iNumPiso;

    // Métodos Get y Set
    public int getNumPiso() { return m_iNumPiso; }
    private void setNumPiso(int value) throws DatosInvalidoException {
        if (value < 0) throw new DatosInvalidoException("El número de pisos no puede ser negativo.");
        this.m_iNumPiso = value;
    }

    // Constructor con parámetros
    public Piso(String p_strDireccion, double p_dbM2, boolean p_bNuevo, int p_iYearsAntiguedad, int p_iNumPiso) throws DatosInvalidoException {
        super(p_strDireccion, p_dbM2, p_bNuevo, p_iYearsAntiguedad);
        setNumPiso(p_iNumPiso);
    }

    // Constructor copia
    public Piso(Piso otro) throws DatosInvalidoException {
        super(otro);
        setNumPiso(otro.getNumPiso());
    }

    /**
     * Método para calcular el precio de un piso
     * @return double dbPrecioFinal
     */
    @Override
    public double calcularPrecio() {
        double dbPrecioFinal = super.calcularPrecio();

        if (this.m_iNumPiso >= 3) {
            dbPrecioFinal += (dbPrecioFinal * 0.03);
        }

        return dbPrecioFinal;
    }

    @Override
    public String toString() {
        return "Dirección: " + getDireccion() + ", m2: " + getM2() + ", Nuevo: " + isNuevo() + " Num de Piso: " + m_iNumPiso + ".";
    }
}
