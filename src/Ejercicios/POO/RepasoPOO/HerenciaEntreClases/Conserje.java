package Ejercicios.POO.RepasoPOO.HerenciaEntreClases;

public class Conserje extends Trabajador {

    // Propiedades
    private String m_strAreaAsignada;

    // Métodos Get y Set
    public String getAreaAsignada() { return m_strAreaAsignada; }
    private void setAreaAsignada(String value) { this.m_strAreaAsignada = value; }

    // Constructor con parámetros
    public Conserje(String p_strNombre, String p_strApellidos, double p_dbSalario, int p_iNumDespacho, String p_strAreaAsignada) {
        super(p_strNombre, p_strApellidos, p_dbSalario, p_iNumDespacho);
        setAreaAsignada(p_strAreaAsignada);
    }

    // Constructor por defecto
    public Conserje() {
        this("Sin Nombre", "Sin Apellidos", 0.0, 0, "Sin area asignada");
    }

    // Constructor copia
    public Conserje(Conserje otro) {
        super(otro.getNombre(), otro.getApellidos(), otro.getSalario(), otro.getNumDespacho());
        setAreaAsignada(otro.getAreaAsignada());
    }

    @Override
    public String toString() {
        return super.toString() + " | Area asignada: " + m_strAreaAsignada;
    }
}
