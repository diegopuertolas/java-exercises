package Ejercicios.POO.RepasoPOO.HerenciaEntreClases;

public class Trabajador extends Persona {

    // Propiedades
    private double m_dbSalario;
    private int m_iNumDespacho;

    // Métodos Get
    public double getSalario() { return m_dbSalario; }
    public int getNumDespacho() { return m_iNumDespacho; }

    // Métodos Set
    private void setSalario(double value) { this.m_dbSalario = value; }
    private void setNumDespacho(int value) { this.m_iNumDespacho = value; }

    // Constructor con parámetros
    public Trabajador(String p_strNombre, String p_strApellidos, double p_dbSalario, int p_iNumDespacho) {
        super(p_strNombre, p_strApellidos);
        setSalario(p_dbSalario);
        setNumDespacho(p_iNumDespacho);
    }

    // Constructor por defecto
    public Trabajador() {
        this("Indefinido", "Indefinido", 0.0, 0);
    }

    // Constructor copia
    public Trabajador(Trabajador otro) {
        super(otro.getNombre(), otro.getApellidos());
        setSalario(otro.getSalario());
        setNumDespacho(otro.getNumDespacho());
    }

    @Override
    public String toString() {
        return super.toString() + " | Salario: " + m_dbSalario + " | Num de Despacho: " + m_iNumDespacho;
    }
}
