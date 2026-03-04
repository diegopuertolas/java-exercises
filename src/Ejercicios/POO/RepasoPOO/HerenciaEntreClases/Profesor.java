package Ejercicios.POO.RepasoPOO.HerenciaEntreClases;

public class Profesor extends Trabajador {

    // Propiedades
    private String m_strDepartamento;

    // Métodos Get y Set
    public String getDepartamento() { return m_strDepartamento; }
    private void setDepartamento(String value) { this.m_strDepartamento = value; }

    // Constructor con parámetros
    public Profesor(String p_strNombre, String p_strApellidos, double p_dbSalario, int p_iNumDespacho, String p_strDepartamento) {
        super(p_strNombre, p_strApellidos, p_dbSalario, p_iNumDespacho);
        setDepartamento(p_strDepartamento);
    }

    // Constructor por defecto
    public Profesor() {
        this("Sin Nombre", "Sin Apellidos", 0.0, 0, "Sin departamento");
    }

    // Constructor copia
    public Profesor(Profesor otro) {
        super(otro.getNombre(), otro.getApellidos(), otro.getSalario(), otro.getNumDespacho());
        setDepartamento(otro.getDepartamento());
    }

    @Override
    public String toString() {
        return super.toString() + " | Departamento: " + m_strDepartamento;
    }
}
