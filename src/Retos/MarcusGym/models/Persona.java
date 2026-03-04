package Retos.MarcusGym.models;

import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Atributos
    private String m_strDNI;
    private String m_strNombre;
    private String m_strApellidos;
    private int m_iEdad;

    // Métodos Get
    public String getDNI() { return m_strDNI; }
    public String getNombre() { return m_strNombre; }
    public String getApellidos() { return m_strApellidos; }
    public int getEdad() { return m_iEdad; }

    // Métodos Set
    private void setDNI(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El DNI no puede estar vacío.");
        }
        this.m_strDNI = value;
    }

    private void setNombre(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede estar vacío.");
        }
        this.m_strNombre = value;
    }

    private void setApellidos(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El apellido no puede estar vacío.");
        }
        this.m_strApellidos = value;
    }

    private void setEdad(int value) throws DatosInvalidosException {
        if (value <= 0) throw new DatosInvalidosException("La edad no puede ser negativa o igual a 0");
        this.m_iEdad = value;
    }

    // Constructor con parámetros
    public Persona(String p_strDNI, String p_strNombre, String p_strApellidos, int p_iEdad) throws DatosInvalidosException {
        setDNI(p_strDNI);
        setNombre(p_strNombre);
        setApellidos(p_strApellidos);
        setEdad(p_iEdad);
    }

    /**
     * Método abstracto que devuelve un mensaje motivacional de entrenamiento.
     * <p>
     * Las clases hijas deben implementar este método.
     * </p>
     *
     * @return Una cadena de texto que representa el mensaje motivacional.
     */
    public abstract String mostrarRutina();

    @Override
    public String toString() {
        return "DNI: " + getDNI() + " | Nombre: " + getNombre() + " | Apellidos: " + getApellidos() + " | Edad: " + getEdad() + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(m_strDNI, persona.m_strDNI);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(m_strDNI);
    }
}
