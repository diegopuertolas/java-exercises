package Ejercicios.POO.ImplementacionInterfazI;

public class Peso implements IRelaciones {

    // Propiedades
    private double m_dbPeso;

    // Métodos Get y Set
    public double getPeso() { return m_dbPeso; }

    private void setPeso(double value) {
        if (value < 0) throw new IllegalArgumentException("El peso no puede ser negativo");
        this.m_dbPeso = value;
    }

    // Constructor con parámetros
    public Peso(double p_dbPeso) {
        setPeso(p_dbPeso);
    }

    @Override
    public boolean esMayor(Object b) {
        Peso otro = validarYConvertir(b);

        if (otro == null) return false;

        return this.m_dbPeso > otro.getPeso();
    }

    @Override
    public boolean esMenor(Object b) {
        Peso otro = validarYConvertir(b);

        if (otro == null) return false;

        return this.m_dbPeso < otro.getPeso();
    }

    @Override
    public boolean esIgual(Object b) {
        Peso otro = validarYConvertir(b);

        if (otro == null) return false;

        return this.m_dbPeso == otro.getPeso();
    }

    /**
     * Método que recibe un objeto genérico b de la clase Object y devuelve un Peso o null si no es válido.
     * @param b Clase Object
     * @return Peso convertido o null si no es válido
     */
    private Peso validarYConvertir(Object b) {
        if (b instanceof Peso) return (Peso) b; // Down Casting
        return null;
    }
}
