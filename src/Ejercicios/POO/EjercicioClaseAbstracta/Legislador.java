package Ejercicios.POO.EjercicioClaseAbstracta;

public abstract class Legislador extends Persona {

    // Propiedades
    private String m_strProvinciaQueRepresenta;

    // Métodos Get y Set
    public String getProvinciaQueRepresenta() { return m_strProvinciaQueRepresenta; }

    private void setProvinciaQueRepresenta(String value) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("La provincia no puede estar vacío");
        this.m_strProvinciaQueRepresenta = value;
    }

    // Constructor con parámetros
    public Legislador(String p_strNombre, String p_strProvinciaQueRepresenta) {
        super(p_strNombre);
        setProvinciaQueRepresenta(p_strProvinciaQueRepresenta);
    }

    /**
     * Método abstracto que devuelve el nombre de la cámara legislativa.
     * <p>
     * Las clases hijas deben implementar este método para indicar si pertenecen
     * al Congreso, Senado u otra cámara autonómica.
     * </p>
     *
     * @return Cadena con el nombre de la cámara.
     */
    public abstract String getCamaraEnQueTrabaja();
}
