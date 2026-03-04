package Ejercicios.POO.ExcepcionesEjercicios.Ejercicio6;

public class Gato {

    private static final int LONGITUD_MIN = 3;

    // Propiedades
    private String m_strNombre;
    private int m_iEdad;

    // Métodos Get
    public String getNombre() { return m_strNombre; }
    public int getEdad() { return m_iEdad; }

    // Métodos Set
    public void setNombre(String value) throws DatoInvalidoException {
        if (value == null) throw new DatoInvalidoException("El nombre no puede ser nulo.");
        if (value.trim().length() < 3) throw new DatoInvalidoException("El nombre no cumple con la longitud mínima.");
        this.m_strNombre = value;
    }

    public void setEdad(int value) throws DatoInvalidoException {
        if (value < 0) throw new DatoInvalidoException("La edad no puede ser negativa.");
        this.m_iEdad = value;
    }

    // Constructor con parámetros
    public Gato(String p_strNombre, int p_iEdad) throws DatoInvalidoException {
        setNombre(p_strNombre);
        setEdad(p_iEdad);
    }

    /**
     * Método para imprimir el nombre y la edad de un objeto de la clase Gato.
     */
    public void imprimir() {
        System.out.println("NOMBRE: " + this.m_strNombre + " | EDAD: " + this.m_iEdad);
    }

}
