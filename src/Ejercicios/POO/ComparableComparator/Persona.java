package Ejercicios.POO.ComparableComparator;

public class Persona implements Comparable {

    // Propiedades
    private int m_iId;
    private String m_strNombre;
    private int m_iEdad;

    // Métodos Get
    public int getId() { return m_iId; }
    public String getNombre() { return m_strNombre; }
    public int getEdad() { return m_iEdad; }

    // Métodos Set
    private void setId(int value) {
        this.m_iId = value;
    }

    private void setNombre(String value) {
        this.m_strNombre = value;
    }

    private void setEdad(int value) {
        this.m_iEdad = value;
    }

    // Constructor con parámetros
    public Persona(int p_iId, String p_strNombre, int p_iEdad) {
        setId(p_iId);
        setNombre(p_strNombre);
        setEdad(p_iEdad);
    }

    @Override
    public String toString() {
        return "Id=" + m_iId + ", Nombre='" + m_strNombre + '\'' + ", Edad=" + m_iEdad + "| ";
    }

    @Override
    public int compareTo(Object o) {
        return getId() - ((Persona)o).getId();
    }
}

// ordenacion con metodo burbuja