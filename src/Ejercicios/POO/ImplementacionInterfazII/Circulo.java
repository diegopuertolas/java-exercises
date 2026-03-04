package Ejercicios.POO.ImplementacionInterfazII;

public class Circulo implements IFigura {

    // Propiedades
    private double m_dbRadio;

    // Métodos Get y Set
    public double getRadio() { return m_dbRadio; }

    private void setRadio(double value) {
        if (value <= 0) throw new IllegalArgumentException("El radio no puede tener una longitud negativa o igual a 0");
        this.m_dbRadio = value;
    }

    // Constructor con parámetros
    public Circulo(double p_dbRadio) {
        setRadio(p_dbRadio);
    }

    @Override
    public double getPerimetro() {
        return Math.PI * (2 * this.m_dbRadio);
    }

    @Override
    public double getArea() {
        return Math.PI * (this.m_dbRadio * this.m_dbRadio);
    }
}
