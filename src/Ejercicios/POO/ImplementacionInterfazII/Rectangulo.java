package Ejercicios.POO.ImplementacionInterfazII;

public class Rectangulo implements IFigura {

    // Propiedades
    private double m_dbBase;
    private double m_dbAltura;

    // Métodos Get y Set
    public double getBase() { return m_dbBase; }

    private void setBase(double value) {
        if (value <= 0) throw new IllegalArgumentException("La base no puede tener una longitud negativa o igual a 0");
        this.m_dbBase = value;
    }

    public double getAltura() { return m_dbAltura; }

    private void setAltura(double value) {
        if (value <= 0) throw new IllegalArgumentException("La altura no puede tener una longitud negativa o igual a 0");
        this.m_dbAltura = value;
    }

    // Constructor con parámetros
    public Rectangulo(double p_dbBase, double p_dbAltura) {
        setBase(p_dbBase);
        setAltura(p_dbAltura);
    }

    @Override
    public double getPerimetro() {
        return 2 * (this.m_dbBase + this.m_dbAltura);
    }

    @Override
    public double getArea() {
        return this.m_dbBase * this.m_dbAltura;
    }
}
