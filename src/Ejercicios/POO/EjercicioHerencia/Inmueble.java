package Ejercicios.POO.EjercicioHerencia;

public class Inmueble {

    private static final double EURO_M2 = 2897;

    // Propiedades
    private String m_strDireccion;
    private double m_dbM2;
    private boolean m_bNuevo;
    private int m_iYearsAntiguedad;

    // Métodos Get
    public String getDireccion() { return m_strDireccion; }
    public double getM2() { return m_dbM2; }
    public boolean isNuevo() { return m_bNuevo; }
    public int getYearsAntiguedad() { return m_iYearsAntiguedad; }

    // Métodos Set
    private void setDireccion(String value) throws DatosInvalidoException {
        if (value == null || value.trim().isEmpty()) throw new DatosInvalidoException("La dirección no puede estar vacía.");
        this.m_strDireccion = value;
    }

    private void setM2(double value) throws DatosInvalidoException {
        if (value <= 0) throw new DatosInvalidoException("Los metros cuadrados deben ser mayores que 0.");
        this.m_dbM2 = value;
    }

    private void setNuevo(boolean value) {
        this.m_bNuevo = value;
    }

    private void setYearsAntiguedad(int value) throws DatosInvalidoException {
        if (value < 0) throw new DatosInvalidoException("La antiguedad no puede ser negativa.");
        this.m_iYearsAntiguedad = value;
    }

    // Constructor con parámetros
    public Inmueble(String p_strDireccion, double p_dbM2, boolean p_bNuevo, int p_iYearsAntiguedad) throws DatosInvalidoException {
        setDireccion(p_strDireccion);
        setM2(p_dbM2);
        setNuevo(p_bNuevo);
        setYearsAntiguedad(p_iYearsAntiguedad);
    }

    // Constructor copia
    public Inmueble(Inmueble otro) throws DatosInvalidoException {
        validarObjeto(otro);

        setDireccion(otro.getDireccion());
        setM2(otro.getM2());
        setNuevo(otro.isNuevo());
        setYearsAntiguedad(otro.getYearsAntiguedad());
    }

    /**
     * Método para calcular el precio de un inmueble
     * @return double
     */
    public double calcularPrecio() {
        double dbPrecioBase = this.m_dbM2 * EURO_M2;

        if (this.m_iYearsAntiguedad < 15) {
            dbPrecioBase -= (dbPrecioBase * 0.01);
        } else {
            dbPrecioBase -= (dbPrecioBase * 0.02);
        }
        return dbPrecioBase;
    }

    /**
     * Método para validar si un objeto es nulo, si lo es lanzamos excepción.
     * @param obj Clase Object
     */
    private static void validarObjeto(Object obj) {
        if (obj == null) throw new IllegalArgumentException("El objeto no puede ser nulo.");
    }

    @Override
    public String toString() {
        return "Datos inmueble \n\r Direccion:  " + m_strDireccion + ".\n\r" + "M2: " + m_dbM2 + ".\n\r" +
                "Nuevo: " + m_bNuevo + ".\n\r" + ", Años de antiguedad: " + m_iYearsAntiguedad + ".";
    }
}
