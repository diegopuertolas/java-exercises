package Ejercicios.POO.EjercicioClaseAbstracta;

public class Persona {

    // Propiedades
    private String m_strNombre;

    // Métodos Get y Set
    public String getNombre() { return m_strNombre; }

    private void setNombre(String value) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        this.m_strNombre = value;
    }

    // Constructor con parámetros
    public Persona(String p_strNombre) {
        setNombre(p_strNombre);
    }

}
