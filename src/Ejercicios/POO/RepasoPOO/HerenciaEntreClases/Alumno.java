package Ejercicios.POO.RepasoPOO.HerenciaEntreClases;

public class Alumno extends Persona {

    // Propiedades
    private String m_strCurso;
    private double m_dbNota;

    // Métodos Get
    public String getCurso() { return m_strCurso; }
    public double getNota() { return m_dbNota; }

    // Métodos Set
    private void setCurso(String value) { this.m_strCurso = value; }
    private void setNota(double value) { this.m_dbNota = value; }

    // Constructor con parámetros
    public Alumno(String p_strNombre, String p_strApellidos, String p_strCurso, double p_dbNota) {
        super(p_strNombre, p_strApellidos);
        setCurso(p_strCurso);
        setNota(p_dbNota);
    }

    // Constructor por defecto
    public Alumno() {
        this("Indefinido", "Indefinido", "Sin Curso", 0.0);
    }

    // Constructor copia
    public Alumno(Alumno otro) {
        super(otro.getNombre(), otro.getApellidos());
        setCurso(otro.getCurso());
        setNota(otro.getNota());
    }

    @Override
    public String toString() {
        return super.toString() + " | Curso: " + m_strCurso + " | Nota: " + m_dbNota;
    }
}
