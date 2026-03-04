package Ejercicios.POO.EjercicioHerencia;

public class Local extends Inmueble {

    // Propiedades
    private int m_iNumVentanas;

    // Métodos Get y Set
    public int getNumVentanas() { return m_iNumVentanas; }

    private void setNumVentanas(int value) throws DatosInvalidoException {
        if (value < 0) throw new DatosInvalidoException("El número de ventanas no puede ser negativo.");
        this.m_iNumVentanas = value;
    }

    // Constructor con parámetros
    public Local(String p_strDireccion, double p_dbM2, boolean p_bNuevo, int p_iYearsAntiguedad, int p_iNumVentanas) throws DatosInvalidoException {
        super(p_strDireccion, p_dbM2, p_bNuevo, p_iYearsAntiguedad);
        setNumVentanas(p_iNumVentanas);
    }

    // Constructor copia
    public Local(Local otro) throws DatosInvalidoException {
        super(otro);
        setNumVentanas(otro.getNumVentanas());
    }

    /**
     * Método para calcular el precio de un Local.
     * @return double dbPrecioFinal
     */
    @Override
    public double calcularPrecio() {
        double dbPrecioFinal = super.calcularPrecio();

        if (this.getM2() > 50) {
            dbPrecioFinal += (dbPrecioFinal * 0.01);
        }

        if (this.m_iNumVentanas <= 1) {
            dbPrecioFinal -= (dbPrecioFinal * 0.02);
        } else if (this.m_iNumVentanas > 4) {
            dbPrecioFinal += (dbPrecioFinal * 0.02);
        }

        return dbPrecioFinal;
    }

    @Override
    public String toString() {
        return "Dirección: " + getDireccion() + ", m2: " + getM2() + ", Nuevo: " + isNuevo() + " Num de Ventanas: " + m_iNumVentanas + ".";
    }
}
