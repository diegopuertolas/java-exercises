package Ejercicios.Colecciones.DMSv2.model;

import Ejercicios.Colecciones.DMSv2.enums.Periodo;
import Ejercicios.Colecciones.DMSv2.exceptions.DatosInvalidosException;

public abstract class Dinosaurio implements Interactivo {

    // Propiedades
    private String m_strNombre;
    private double m_dbSize;
    private Periodo m_ePeriodo;

    // Métodos Get
    public String getNombre() { return m_strNombre; }
    public double getSize() { return m_dbSize; }
    public Periodo getPeriodo() { return m_ePeriodo; }

    // Métodos Set
    private void setNombre(String value) throws DatosInvalidosException {
        if (value == null || value.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del dinosaurio no puede estar vacío.");
        }
        this.m_strNombre = value;
    }

    private void setSize(double value) throws DatosInvalidosException {
        if (value <= 0) throw new DatosInvalidosException("El tamaño debe ser mayor que 0.");
        this.m_dbSize = value;
    }

    private void setPeriodo(Periodo value) {
        if (value == null) {
            throw new IllegalArgumentException("El periodo no puede ser nulo.");
        }
        this.m_ePeriodo = value;
    }

    // Constructor con parámetros
    public Dinosaurio(String p_strNombre, double p_dbSize, Periodo p_ePeriodo) throws DatosInvalidosException {
        setNombre(p_strNombre);
        setSize(p_dbSize);
        setPeriodo(p_ePeriodo);
    }

    /**
     * Método abstracto que devuelve el sonido que hace un dinosaurio al rugir.
     * <p>
     * Las clases hijas deben implementar este método para rugir de la forma en la que lo hagan.
     * </p>
     *
     * @return Una cadena de texto que representa el rugido del dinosaurio.
     */
    public abstract String rugir();

    @Override
    public void mostrarInformacion() {
        System.out.println("--- INFORMACIÓN DEL DINOSAURIO ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Tamaño: " + getSize());
        System.out.println("Periodo: " + getPeriodo());
        System.out.println("Rugido: " + rugir());
    }

    @Override
    public void atraccionEstrella() {
        System.out.println("--- ATRACCIÓN ESTRELLA ---");
        System.out.println("El gran... " + getNombre());
    }

}
